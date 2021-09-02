
unit WebForm2;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls, 
  System.Data.SqlClient;

type
  TWebForm2 = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    SqlConnection1: System.Data.SqlClient.SqlConnection;
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
procedure TWebForm2.InitializeComponent;
begin
  Self.SqlConnection1 := System.Data.SqlClient.SqlConnection.Create;
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="(local)";' +
  'persist security info=True;initial catalog=NorthWind;password=';
  Include(Self.Load, Self.Page_Load);
end;
{$ENDREGION}

type
  TByteArray = array of Byte;

procedure TWebForm2.Page_Load(sender: System.Object; e: System.EventArgs);
const
  c_selphoto = 'SELECT Photo FROM employees WHERE employeeid = {0}';
var
  sqlCmd: SqlCommand;
  selStr: String;
  EmpID: Integer;
  photo: TByteArray;
begin
  EmpID := Integer(Session['EmpID']);
  if EmpID > -1 then
  begin
    selStr := System.String.Format(c_selphoto, [EmpID]);
    SqlConnection1.Open;
    try
      sqlCmd := SqlCommand.Create(selStr, SqlConnection1);
      photo := TByteArray(sqlCmd.ExecuteScalar);
    finally
      SqlConnection1.Close;
    end;
    Response.ContentType := 'image/jpeg';
    Response.OutputStream.Write(photo, 78, System.Array(photo).Length);
  end;
end;

procedure TWebForm2.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

end.

