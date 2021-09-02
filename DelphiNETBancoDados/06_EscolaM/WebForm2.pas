
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
    procedure Button1_Click(sender: System.Object; e: System.EventArgs);
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    Label1: System.Web.UI.WebControls.Label;
    TextBox1: System.Web.UI.WebControls.TextBox;
    TextBox2: System.Web.UI.WebControls.TextBox;
    TextBox3: System.Web.UI.WebControls.TextBox;
    TextBox4: System.Web.UI.WebControls.TextBox;
    TextBox5: System.Web.UI.WebControls.TextBox;
    TextBox6: System.Web.UI.WebControls.TextBox;
    TextBox7: System.Web.UI.WebControls.TextBox;
    Button1: System.Web.UI.WebControls.Button;
    SqlConnection1: System.Data.SqlClient.SqlConnection;
    SqlCommand1: System.Data.SqlClient.SqlCommand;
    SqlCommand2: System.Data.SqlClient.SqlCommand;
    SqlCommand3: System.Data.SqlClient.SqlCommand;
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
  Self.SqlCommand1 := System.Data.SqlClient.SqlCommand.Create;
  Self.SqlCommand2 := System.Data.SqlClient.SqlCommand.Create;
  Self.SqlCommand3 := System.Data.SqlClient.SqlCommand.Create;
  Include(Self.Button1.Click, Self.Button1_Click);
  // 
  // SqlConnection1
  // 
  Self.SqlConnection1.ConnectionString := 'user id=sa;data source="(local)";' +
  'persist security info=True;initial catalog=Escola;password=senha';
  // 
  // SqlCommand1
  // 
  Self.SqlCommand1.CommandText := 'Select * from Aluno where Codigo = @Codig' +
  'o';
  Self.SqlCommand1.Connection := Self.SqlConnection1;
  Self.SqlCommand1.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Codigo', System.Data.SqlDbType.Int, 0, System.Data.ParameterDirection.Input, 
        False, (Byte(0)), (Byte(0)), '', System.Data.DataRowVersion.Current, 
        '1'));
  // 
  // SqlCommand2
  // 
  Self.SqlCommand2.CommandText := ' update aluno set nome = @nome, Email = @' +
  'Email, Nota01 = @Nota01, Nota02 = @Nota02, Nota03 = @Nota03, Nota04 = @No' +
  'ta04 where codigo = @codigo';
  Self.SqlCommand2.Connection := Self.SqlConnection1;
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'codigo', System.Data.SqlDbType.Int));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nome', System.Data.SqlDbType.VarChar));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Email', System.Data.SqlDbType.VarChar));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota01', System.Data.SqlDbType.Real));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota02', System.Data.SqlDbType.Real));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota03', System.Data.SqlDbType.Real));
  Self.SqlCommand2.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota04', System.Data.SqlDbType.Real));
  // 
  // SqlCommand3
  // 
  Self.SqlCommand3.CommandText := 'insert into aluno (Codigo, Nome, Email, N' +
  'ota01, Nota02, Nota03, Nota04) values (@Codigo, @Nome, @Email, @Nota01, @' +
  'Nota02, @Nota03, @Nota04)';
  Self.SqlCommand3.Connection := Self.SqlConnection1;
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Codigo', System.Data.SqlDbType.Int));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nome', System.Data.SqlDbType.VarChar));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Email', System.Data.SqlDbType.VarChar));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota01', System.Data.SqlDbType.Real));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota02', System.Data.SqlDbType.Real));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota03', System.Data.SqlDbType.Real));
  Self.SqlCommand3.Parameters.Add(System.Data.SqlClient.SqlParameter.Create('@' +
      'Nota04', System.Data.SqlDbType.Real));
  Include(Self.Load, Self.Page_Load);
end;
{$ENDREGION}

procedure TWebForm2.Page_Load(sender: System.Object; e: System.EventArgs);
var
  IDaluno, OP : string;
  sqlRdr  : SQLDataReader;
begin
  if Not IsPostBack then
  begin
    // TODO: Put user code to initialize the page here
    IDaluno := Session['IDAluno'].ToString;
    OP      := Session['Operacao'].ToString;

    Label1.Text := OP + ' do Aluno';

    if OP = 'Edi��o' then
    begin
      // Ler os dados completos do aluno a partir do banco de dados
      SqlConnection1.Open;
      SqlCommand1.Parameters[0].Value := IDAluno;
      try
        // Executa o select e transfere o resultado para o Reader
        sqlRdr := SqlCommand1.ExecuteReader;
        sqlRdr.Read;

        // Apresenta nos textbox
        TextBox1.Text := IDAluno;
        TextBox2.Text := sqlRdr['Nome'].ToString;
        TextBox3.Text := sqlRdr['Email'].ToString;
        TextBox4.Text := sqlRdr['Nota01'].ToString;
        TextBox5.Text := sqlRdr['Nota02'].ToString;
        TextBox6.Text := sqlRdr['Nota03'].ToString;
        TextBox7.Text := sqlRdr['Nota04'].ToString;
      finally
        SqlConnection1.Close;
      end;
    end;
    if OP = 'Inser��o' then
    begin
      TextBox1.Text := '';
      TextBox2.Text := '';
      TextBox3.Text := '';
      TextBox4.Text := '';
      TextBox5.Text := '';
      TextBox6.Text := '';
      TextBox7.Text := '';
    end;
  end;

end;

procedure TWebForm2.Button1_Click(sender: System.Object; e: System.EventArgs);
var
  IDAluno, OP : string;
begin
  OP := Session['Operacao'].ToString;
  if OP = 'Edi��o' then
  begin
    // TODO: Put user code to initialize the page here
    IDaluno := Session['IDAluno'].ToString;

    // Ler os dados completos do aluno a partir do banco de dados
      //  update aluno
      //  set nome = @nome, Email = @Email, Nota01 = @Nota01, Nota02 = @Nota02,
      //      Nota03 = @Nota03, Nota04 = @Nota04
      //  where codigo = @codigo
    SqlConnection1.Open;
    SqlCommand2.Parameters[0].Value := IDAluno;
    SqlCommand2.Parameters[1].Value := TextBox2.Text;
    SqlCommand2.Parameters[2].Value := TextBox3.Text;
    SqlCommand2.Parameters[3].Value := TextBox4.Text;
    SqlCommand2.Parameters[4].Value := TextBox5.Text;
    SqlCommand2.Parameters[5].Value := TextBox6.Text;
    SqlCommand2.Parameters[6].Value := TextBox7.Text;
    try
      // Executa o select e transfere o resultado para o Reader
      SqlCommand2.ExecuteNonQuery;

    finally
      SqlConnection1.Close;
    end;
  end;

  // Insere os dados completos do aluno no banco de dados
    //  insert into aluno
    //  (Codigo, Nome, Email, Nota01, Nota02, Nota03, Nota04)
    //  values (@Codigo, @Nome, @Email, @Nota01, @Nota02, @Nota03, @Nota04)
  if OP = 'Inser��o' then
  begin
    SqlConnection1.Open;
    SqlCommand3.Parameters[0].Value := TextBox1.Text;
    SqlCommand3.Parameters[1].Value := TextBox2.Text;
    SqlCommand3.Parameters[2].Value := TextBox3.Text;
    SqlCommand3.Parameters[3].Value := TextBox4.Text;
    SqlCommand3.Parameters[4].Value := TextBox5.Text;
    SqlCommand3.Parameters[5].Value := TextBox6.Text;
    SqlCommand3.Parameters[6].Value := TextBox7.Text;
    try
      // Executa o select e transfere o resultado para o Reader
      SqlCommand3.ExecuteNonQuery;

    finally
      SqlConnection1.Close;
    end;
  end;

  Response.Redirect('WebForm1.aspx');
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

