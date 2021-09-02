
unit PagRecibo;

interface

uses
  System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls,
  System.Web.Security, System.Web.UI.WebControls.WebParts, System.Configuration, 
  System.Drawing.Printing;

type
  TPagRecibo = class(System.Web.UI.Page)
  {$REGION 'Designer Managed Code'}
  strict private
    procedure InitializeComponent;
  {$ENDREGION}
  strict private
    procedure Page_Load(sender: System.Object; e: System.EventArgs);
  strict protected
    LabelName: System.Web.UI.WebControls.&Label;
    LabelQuantia: System.Web.UI.WebControls.&Label;
    LabelExtenso: System.Web.UI.WebControls.&Label;
    LabelAditivo: System.Web.UI.WebControls.&Label;
    LabelEmpresas: System.Web.UI.WebControls.&Label;
    LabelDinheiro: System.Web.UI.WebControls.&Label;
    LabelData: System.Web.UI.WebControls.&Label;
    PrintDocument1: System.Drawing.Printing.PrintDocument;
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
procedure TPagRecibo.InitializeComponent;
begin
  Self.PrintDocument1 := System.Drawing.Printing.PrintDocument.Create;
  Include(Self.Load, Self.Page_Load);
end;
{$ENDREGION}

procedure TPagRecibo.Page_Load(sender: System.Object; e: System.EventArgs);
begin
  // TODO: Put user code to initialize the page here
end;

procedure TPagRecibo.OnInit(e: EventArgs);
begin
  //
  // Required for Designer support
  //
  InitializeComponent;
  inherited OnInit(e);
end;

end.

