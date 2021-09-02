
unit WebForm1;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls, 
  System.Data.SqlClient, System.Globalization;

type
  TWebForm1 = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
    procedure DataGrid1_SelectedIndexChanged(sender: System.Object; e: System.EventArgs);
    procedure Button1_Click(sender: System.Object; e: System.EventArgs);
    procedure DataGrid1_DeleteCommand(source: System.Object; e: System.Web.UI.WebControls.DataGridCommandEventArgs);
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    SqlConnection1: System.Data.SqlClient.SqlConnection;
    sqlSelectCommand1: System.Data.SqlClient.SqlCommand;
    sqlInsertCommand1: System.Data.SqlClient.SqlCommand;
    sqlUpdateCommand1: System.Data.SqlClient.SqlCommand;
    sqlDeleteCommand1: System.Data.SqlClient.SqlCommand;
    SqlDataAdapter1: System.Data.SqlClient.SqlDataAdapter;
    DataSet1: System.Data.DataSet;
    DataTable1: System.Data.DataTable;
    Label1: System.Web.UI.WebControls.Label;
    DataGrid1: System.Web.UI.WebControls.DataGrid;
    Button1: System.Web.UI.WebControls.Button;
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
procedure TWebForm1.InitializeComponent;
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
  Self.DataTable1 := System.Data.DataTable.Create;
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).BeginInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTable1)).BeginInit;
  Include(Self.DataGrid1.DeleteCommand, Self.DataGrid1_DeleteCommand);
  Include(Self.DataGrid1.SelectedIndexChanged, Self.DataGrid1_SelectedIndexChanged);
  Include(Self.Button1.Click, Self.Button1_Click);
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="(local)";' +
  'persist security info=True;initial catalog=Escola;password=senha';
  // 
  // sqlSelectCommand1
  // 
  Self.sqlSelectCommand1.CommandText := 'select Codigo, Nome, email from Alu' +
  'no';
  Self.sqlSelectCommand1.Connection := Self.SqlConnection1;
  // 
  // sqlDeleteCommand1
  // 
  Self.sqlDeleteCommand1.CommandText := 'delete from Aluno where codigo = @c' +
  'odigo';
  Self.sqlDeleteCommand1.Connection := Self.SqlConnection1;
  Self.sqlDeleteCommand1.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'codigo', System.Data.SqlDbType.Int));
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
  Self.DataSet1.Locale := System.Globalization.CultureInfo.Create('pt-BR');
  Self.DataSet1.Tables.AddRange(TArrayOfSystem_Data_DataTable.Create(Self.DataTable1));
  // 
  // DataTable1
  // 
  Self.DataTable1.TableName := 'Table1';
  Include(Self.Load, Self.Page_Load);
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).EndInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTable1)).EndInit;
end;
{$ENDREGION}

procedure TWebForm1.Page_Load(sender: System.Object; e: System.EventArgs);
begin
  // TODO: Put user code to initialize the page here
  if not IsPostBack then
  begin
    SQLDataAdapter1.Fill(DataSet1,'Table1');
    DataBind;
    Session.Add('IDAluno',Convert.ToString(-1));
  end;
end;

procedure TWebForm1.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

procedure TWebForm1.DataGrid1_SelectedIndexChanged(sender: System.Object; e: System.EventArgs);
var
  IDaluno : string;
begin
  IDaluno :=  DataGrid1.SelectedItem.Cells[2].Text;
  Session.Add('IDAluno',IDaluno);
  Session.Add('Operacao','Edi��o');
  Response.Redirect('WebForm2.aspx');
end;

procedure TWebForm1.Button1_Click(sender: System.Object; e: System.EventArgs);
begin
  Session.Add('IDAluno','-1');
  Session.Add('Operacao','Inser��o');
  Response.Redirect('WebForm2.aspx');
end;

procedure TWebForm1.DataGrid1_DeleteCommand(source: System.Object; e: System.Web.UI.WebControls.DataGridCommandEventArgs);
var
  IDaluno : string;
begin
  IDaluno :=  e.Item.Cells[2].Text;

  SqlConnection1.Open;
  SqlDataAdapter1.DeleteCommand.Parameters[0].Value := IDAluno;
  try
    // Executa o select e transfere o resultado para o Reader
    SqlDataAdapter1.DeleteCommand.ExecuteNonQuery;

  finally
    SqlConnection1.Close;
  end;
  Response.Redirect('WebForm1.aspx');
end;

end.

