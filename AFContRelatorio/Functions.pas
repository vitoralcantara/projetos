unit Functions;

interface
uses System.Collections, System.ComponentModel,
  System.Data, System.Drawing, System.Web, System.Web.SessionState,
  System.Web.UI, System.Web.UI.WebControls, System.Web.UI.HtmlControls,
  System.Web.Security, System.Web.UI.WebControls.WebParts, System.Configuration,
  System.Data.SqlClient;

type
  TFunctions = class
  private
    { Private Declarations }
  public
    constructor Create;
    function bissexto(ano: integer): boolean;
    procedure preencherDDL(var DDL: DropDownList; fim: integer);
    procedure checkMesDDL(var ddlDia: DropDownList;var ddlMes: DropDownList;var ddlAno: DropDownList);


  end;

implementation

function TFunctions.bissexto(ano: integer): boolean;
begin
  if ano mod 400 = 0 then
    result := true
  else if (ano mod 4 = 0) and (ano mod 100 <> 0) then
    result := true
  else
    result := false;
end;

function TFunctions.preencherDDL(var DDL: DropDownList; fim: integer);
var
  i: integer;
begin
     for i := 1 to fim do
       DDL.Items.Add(i.tostring);
end;




constructor TFunctions.Create;
begin
  inherited Create;
  // TODO: Add any constructor code here
end;

end.
