
unit RelatorioToPrint;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls,
  System.Web.Security, System.Web.UI.WebControls.WebParts, System.Configuration, 
  System.Drawing.Printing, System.Data.SqlClient;

type
  TRelatorioToPrint = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    GVRelCaixaMovimento: System.Web.UI.WebControls.GridView;
    SqlConnection1: System.Data.SqlClient.SqlConnection;
    DataSet1: System.Data.DataSet;
    LabelDataInicio: System.Web.UI.WebControls.&Label;
    LabelDataFim: System.Web.UI.WebControls.&Label;
    sqlSelectCommand1: System.Data.SqlClient.SqlCommand;
    sqlInsertCommand1: System.Data.SqlClient.SqlCommand;
    sqlUpdateCommand1: System.Data.SqlClient.SqlCommand;
    sqlDeleteCommand1: System.Data.SqlClient.SqlCommand;
    SqlDataAdapter1: System.Data.SqlClient.SqlDataAdapter;
    DataTableRelCaixaMov: System.Data.DataTable;
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
procedure TRelatorioToPrint.InitializeComponent;
type
  TArrayOfSystem_Data_DataTable = array of System.Data.DataTable;
begin
  Self.SqlConnection1 := System.Data.SqlClient.SqlConnection.Create;
  Self.DataSet1 := System.Data.DataSet.Create;
  Self.DataTableRelCaixaMov := System.Data.DataTable.Create;
  Self.sqlSelectCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlInsertCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlUpdateCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.sqlDeleteCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.SqlDataAdapter1 := System.Data.SqlClient.SqlDataAdapter.Create;
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).BeginInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableRelCaixaMov)).BeginInit;
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;initial catalog=AFCont' +
  ';persist security info=True;password=senha';
  Self.SqlConnection1.FireInfoMessageEventOnUserErrors := False;
  // 
  // DataSet1
  // 
  Self.DataSet1.DataSetName := 'NewDataSet';
  Self.DataSet1.Tables.AddRange(TArrayOfSystem_Data_DataTable.Create(Self.DataTableRelCaixaMov));
  // 
  // DataTableRelCaixaMov
  // 
  Self.DataTableRelCaixaMov.TableName := 'TableRelCaixaMov';
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
  Include(Self.Load, Self.Page_Load);
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).EndInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableRelCaixaMov)).EndInit;
end;
{$ENDREGION}

procedure TRelatorioToPrint.Page_Load(sender: System.Object; e: System.EventArgs);
const
stringCon = 'select caixa_movimento.cod_caixa_movimento, '
+'conta.descricao_conta, empresa.razao_social, tiporecdesp.descricao, '
+'conta_extrato.valor_pago, operacao.operacao from caixa_movimento '
+'inner join conta_extrato on caixa_movimento.cod_extrato = '
+'conta_extrato.cod_extrato inner join conta_parcela on conta_parcela.cod_conta_parcela '
+'= conta_extrato.cod_conta_parcela inner join conta on conta.cod_conta = '
+'conta_parcela.cod_conta left join empresa on empresa.cod_empresa = conta.cod_empresa left '
+'join tiporecdesp on conta.cod_tipord = tiporecdesp.cod_tipord left join operacao on '
+'Caixa_movimento.cod_operacao = Operacao.cod_operacao inner join '
+'caixa on caixa_movimento.cod_caixa = caixa.cod_caixa where '
+'day(caixa.data_hora_abertura) = {0} and month(caixa.data_hora_abertura) '
+'= {1} and year(caixa.data_hora_abertura) = {2}';

var
  conFormat : string;
begin
  conFormat := System.String.Format(stringCon,Session['Dia'].ToString,
  Session['Mes'].ToString, Session['Ano'].ToString);
  if session['EnterExit'].ToString = 'ES' then
  else if Session['EnterExit'].ToString = 'E' then
           conFormat := conFormat + ' and conta.receita_ou_despesa = 1'
  else if Session['EnterExit'].ToString = 'S' then
           conFormat := conFormat + ' and conta.receita_ou_despesa = 0';
  SqlConnection1.Open;
  //Response.Write(conFormat);
  SqlDataAdapter1.SelectCommand.CommandText := conFormat;
  SqlDataAdapter1.Fill(DataSet1,'TableRelatorio');
  GVRelCaixaMovimento.DataSource := DataSet1;//DataTableRelCaixaMov.DefaultView;
  GVRelCaixaMovimento.DataMember := 'TableRelatorio';
  GVRelCaixaMovimento.DataBind;
  SqlConnection1.Close;
end;


procedure TRelatorioToPrint.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

end.

