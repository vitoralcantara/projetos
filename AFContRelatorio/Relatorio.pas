
unit Relatorio;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls,
  System.Web.Security, System.Web.UI.WebControls.WebParts, System.Configuration;

type
  TRelatorio = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
    procedure Button1_Click(sender: TObject; e: System.EventArgs);
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    t1: System.Web.UI.WebControls.TextBox;
    t2: System.Web.UI.WebControls.TextBox;
    t3: System.Web.UI.WebControls.TextBox;
    t4: System.Web.UI.WebControls.TextBox;
    t5: System.Web.UI.WebControls.TextBox;
    t6: System.Web.UI.WebControls.TextBox;
    Button1: System.Web.UI.WebControls.Button;
    Label1: System.Web.UI.WebControls.&Label;
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
procedure TRelatorio.InitializeComponent;
begin
  Include(Self.Button1.Click, Self.Button1_Click);
  Include(Self.Load, Self.Page_Load);
end;

procedure TRelatorio.Button1_Click(sender: TObject; e: System.EventArgs);
var
 dataInicio : DateTime;
 dataFim : DateTime;
begin
  // TODO: Put user code to initialize the page here
  dataInicio := Convert.ToDateTime(t1.text+'/'+t2.text+'/'+t3.text);
  dataFim := Convert.ToDateTime(t4.text+'/'+t5.text+'/'+t6.text);
  if dataInicio < dataFim then
    Label1.Text := 'data inicio menor que a data fim'
  else if dataInicio = dataFim then
    Label1.Text := 'data inicio = data fim'
  else
    Label1.Text := 'data inicio maior que data fim';
end;
{$ENDREGION}

procedure TRelatorio.Page_Load(sender: System.Object; e: System.EventArgs);
 begin
 
 end;


procedure TRelatorio.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

end.

