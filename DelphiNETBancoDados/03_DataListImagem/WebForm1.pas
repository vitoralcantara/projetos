
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
    procedure RadioButtonList1_SelectedIndexChanged(sender: System.Object; e: System.EventArgs);
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
    DataTableEmployee: System.Data.DataTable;
    RadioButtonList1: System.Web.UI.WebControls.RadioButtonList;
    Label1: System.Web.UI.WebControls.Label;
    Button1: System.Web.UI.WebControls.Button;
    Image1: System.Web.UI.WebControls.Image;
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
  Self.DataTableEmployee := System.Data.DataTable.Create;
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).BeginInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableEmployee)).BeginInit;
  Include(Self.RadioButtonList1.SelectedIndexChanged, Self.RadioButtonList1_SelectedIndexChanged);
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="(local)";' +
  'persist security info=True;initial catalog=northwind;password=';
  // 
  // sqlSelectCommand1
  // 
  Self.sqlSelectCommand1.CommandText := 'SELECT * FROM employees';
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
  Self.DataSet1.Locale := System.Globalization.CultureInfo.Create('pt-BR');
  Self.DataSet1.Tables.AddRange(TArrayOfSystem_Data_DataTable.Create(Self.DataTableEmployee));
  // 
  // DataTableEmployee
  // 
  Self.DataTableEmployee.TableName := 'Employee';
  Include(Self.Load, Self.Page_Load);
  (System.ComponentModel.ISupportInitialize(Self.DataSet1)).EndInit;
  (System.ComponentModel.ISupportInitialize(Self.DataTableEmployee)).EndInit;
end;
{$ENDREGION}

procedure TWebForm1.Page_Load(sender: System.Object; e: System.EventArgs);
begin
//  Session.Add('EmpID', System.Object(-1));
  if not ispostback then
  begin
    Image1.Visible := False;
    Label1.Visible := False;

    SqlDataAdapter1.Fill(Dataset1, 'Employee');
    DataBind;
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

procedure TWebForm1.RadioButtonList1_SelectedIndexChanged(sender: System.Object;
  e: System.EventArgs);
const
  c_sel   = 'SELECT FirstName, LastName, Title, TitleOfCourtesy, Notes '+
            ' FROM employees WHERE employeeid = {0}';
var
  sqlCmd: SqlCommand;
  sqlRdr: SqlDataReader; // Le o resultado de um comando SQL
  selStr: String;
  EmpID: Integer;
  Line: String;
begin
//  Image1.Visible := True;
  Label1.Visible := True;
  // Codigo do Funcionario Selecionado-> RadioButtonList1.SelectedValue

  EmpID := Convert.ToInt32(RadioButtonList1.SelectedValue);
  // Substitui o parametro {0} do string pelo codigo do funcionario
  selStr := System.String.Format(c_sel, [EmpID]);
  // Cria o comando sql com o funcionario selecionado
  //   a ser consultado pela sqlconnection1
  sqlCmd := SqlCommand.Create(selStr, SqlConnection1);
  // Abre a conex�o com o banco de dados
  SqlConnection1.Open;
  try
    // Executa o select e transfere o resultado para o Reader
    sqlRdr := sqlCmd.ExecuteReader;
    sqlRdr.Read;

    // Line contem o nome do funcionario em negrito
    Line := System.String.Format('<b>{0} {1} {2}</b><br>',
      [sqlRdr['TitleOfCourtesy'], sqlRdr['FirstName'], sqlRdr['LastName']]);

    Label1.Text := Line;
    Label1.Text := Label1.Text + sqlRdr['Title'].ToString+'<hr>';
    Label1.Text := Label1.Text + sqlRdr['Notes'].ToString;
    //Session.Add('EmpID', System.Object(EmpID));
  finally
    SqlConnection1.Close;
  end;
end;

end.

