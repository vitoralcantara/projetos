
unit RelatorioCaixa;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls,
  System.Web.Security, System.Web.UI.WebControls.WebParts, System.Configuration, 
  System.Data.SqlClient;

type
  TRelatorioCaixa = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
    procedure Calendar1_SelectionChanged(sender: TObject; e: System.EventArgs);
    procedure Button1_Click(sender: TObject; e: System.EventArgs);
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    RBMes: System.Web.UI.WebControls.RadioButton;
    RBPeriodo: System.Web.UI.WebControls.RadioButton;
    LabelAlerta: System.Web.UI.WebControls.&Label;
    GridView1: System.Web.UI.WebControls.GridView;
    SqlConnection1: System.Data.SqlClient.SqlConnection;
    sqlSelectCommand1: System.Data.SqlClient.SqlCommand;
    sqlInsertCommand1: System.Data.SqlClient.SqlCommand;
    sqlUpdateCommand1: System.Data.SqlClient.SqlCommand;
    sqlDeleteCommand1: System.Data.SqlClient.SqlCommand;
    SqlDataAdapter1: System.Data.SqlClient.SqlDataAdapter;
    DataSet1: System.Data.DataSet;
    DataTableCaixa: System.Data.DataTable;
    Button1: System.Web.UI.WebControls.Button;
    Button2: System.Web.UI.WebControls.Button;
    CalendarEntrada: System.Web.UI.WebControls.Calendar;
    CalendarSaida: System.Web.UI.WebControls.Calendar;
  protected
    procedure OnInit(e: EventArgs); override;
  private
    { Private Declarations }
  public
    { Public Declarations }
  end;

implementation

{$REGION 'Designer Managed Code'}
/// <summary>
/// Required method for Designer support -- do not modify
/// the contents of this method with the code editor.
/// </summary>
procedure TRelatorioCaixa.InitializeComponent;
type
  TArrayOfSystem_Data_DataTable = array of System.Data.DataTable;
begin
  Self.SqlConnection1 := System.Data.SqlClient.SqlConnection.Create;
  Self.sqlSelectCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlInsertCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlUpdateCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlDeleteCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.SqlDataAdapter1 := System.Data.SqlClient.SqlDataAdapter.Create;
  Self.DataSet1 := System.Data.DataSet.Create;
  Self.DataTableCaixa := System.Data.DataTable.Create;
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).BeginInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableCaixa)).BeginInit;
  Include(Self.CalendarEntrada.SelectionChanged, Self.Calendar1_SelectionChanged);
  Include(Self.Button1.Click, Self.Button1_Click);
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="CESAR-9A7' +
  'E5DF0A\SQLEXPRESS";persist security info=True;initial catalog=AFCont;pass' +
  'word=senha';
  Self.SqlConnection1.FireInfoMessageEventOnUserErrors := False;
  // 
  // sqlSelectCommand1
  // 
  Self.sqlSelectCommand1.Connection := Self.SqlConnection1;
  // 
  // SqlDataAdapter1
  // 
  Self.SqlDataAdapter1.DeleteCommand := Self.sqlDeleteCommand1;
  Self.SqlDataAdapter1.InsertCommand := Self.sqlInsertCommand1;
  Self.SqlDataAdapter1.SelectCommand := Self.sqlSelectCommand1;
  Self.SqlDataAdapter1.UpdateCommand := Self.sqlUpdateCommand1;
  // 
  // DataSet1
  // 
  Self.DataSet1.DataSetName := 'NewDataSet';
  Self.DataSet1.Tables.AddRange(TArrayOfSystem_Data_DataTable.Create(Self.DataTableCaixa));
  // 
  // DataTableCaixa
  // 
  Self.DataTableCaixa.TableName := 'Caixa';
  Include(Self.Load, Self.Page_Load);
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).EndInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableCaixa)).EndInit;
end;
{$ENDREGION}

procedure TRelatorioCaixa.Page_Load(sender: System.Object; e: System.EventArgs);
begin
  // TODO: Put user code to initialize the page here
end;

procedure TRelatorioCaixa.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

procedure TRelatorioCaixa.Button1_Click(sender: TObject; e: System.EventArgs);
const
  stringSearch = 'select cod_caixa as Codigo, data_hora_abertura as DataAbertura, '
  +'data_hora_fechamento as DataFechamento, saldo as Saldo , Usuario.nome as Responsavel from Caixa, '
  +'Usuario where data_hora_abertura  > '+chr(39)+'{0}'+chr(39)+' and data_hora_fechamento < '+chr(39)+'{1}'+chr(39)
  +' and data_hora_fechamento is not NULL and usuario.cod_usuario = caixa.cod_usuario';
var
  tempEntrada : string;
  tempSaida : string;
begin
  if RBMes.Checked = true then
    begin
      tempEntrada := '01/'+DateTime.get_Now.Month.ToString+'/'
      +DateTime.get_Now.year.ToString+' 00:00:00';
      tempSaida := DateTime.get_Now.ToString;
      LabelAlerta.text := 'RbMes Checked';
    end
  else
    begin
       tempEntrada := CalendarEntrada.SelectedDate.Date.ToString;
       tempSaida := CalendarSaida.SelectedDate.Date.ToString;
    end;
  if CalendarEntrada.SelectedDate > CalendarSaida.SelectedDate then
    LabelAlerta.Text := 'Opa! Foi selecionado inversamente um intervalo para o Calendário'
  else
  begin

    SqlConnection1.Open;
    sqlSelectCommand1.CommandText := System.String.Format(stringSearch,tempEntrada,tempSaida);
    sqlSelectCommand1.ExecuteNonQuery;
    SqlDataAdapter1.Fill(DataSet1,'Caixa');
    GridView1.DataSource := DataTableCaixa.DefaultView;
    databind;
    //LabelAlerta.Text := System.String.Format(stringSearch,tempEntrada,tempSaida);
  end;



end;

procedure TRelatorioCaixa.Calendar1_SelectionChanged(sender: TObject; e: System.EventArgs);
begin

end;

end.

