
unit PesquisaCaixa;

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
    
    procedure ButPesCaiaxs_Click(sender: TObject; e: System.EventArgs);
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
    ButPesCaixas: System.Web.UI.WebControls.Button;
    ButRelExib: System.Web.UI.WebControls.Button;
    LabelSaldoIntervalo: System.Web.UI.WebControls.&Label;
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
  Include(Self.ButPesCaixas.Click, Self.ButPesCaiaxs_Click);
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="(local)";' +
  'persist security info=True;initial catalog=AFCont;password=senha';
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

procedure TRelatorioCaixa.ButPesCaiaxs_Click(sender: TObject; e: System.EventArgs);
const
  caixaStringCon = 'SET DATEFORMAT dmy '
  +'select caixa.cod_caixa, caixa.data_hora_abertura, caixa.data_hora_fechamento, caixa.saldo from caixa where '
+'caixa.data_hora_abertura >= ''{0}'' and caixa.data_hora_abertura <= ''{1}''';
var
  i: integer;
  somaSaldo : integer;
  stringCaixa : string;
begin
  if RBPeriodo.Checked then
    stringCaixa := System.String.Format(caixaStringCon,CalendarEntrada.SelectedDate.Date.ToString,
    CalendarSaida.SelectedDate.Date.ToString)
  else
    stringCaixa := System.String.Format(caixaStringCon,'1/'+DateTime.get_Now.Month.ToString+'/'+DateTime.get_Now.Year.ToString+' 00:00:00',
    DateTime.get_Now.ToString);



    SqlConnection1.Open;
    SqlDataAdapter1.SelectCommand.CommandText := stringCaixa;
    SqlDataAdapter1.Fill(DataSet1,'Caixa');
    GridView1.DataSource := DataTableCaixa.DefaultView;
    DataBind;
    somaSaldo := 0;
    //LabelSaldoIntervalo.Text := GridView1.Rows.Item[0].Cells.Item[4].Text;
    for i := 0 to GridView1.Rows.count -1 do
      somaSaldo := somaSaldo + Convert.ToInt32(GridView1.Rows.Item[i].Cells.Item[4].Text);
    LabelSaldoIntervalo.text := 'Saldo entre os Caixas selecionados: ' + somaSaldo.ToString;

end;

procedure TRelatorioCaixa.Calendar1_SelectionChanged(sender: TObject; e: System.EventArgs);
begin

end;

end.

