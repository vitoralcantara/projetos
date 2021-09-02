unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Borland.Vcl.StdCtrls, System.ComponentModel;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    Edit1: TEdit;
    Label2: TLabel;
    Edit2: TEdit;
    Button1: TButton;
    Button2: TButton;
    Button3: TButton;
    Button4: TButton;
    Label3: TLabel;
    Edit3: TEdit;
    procedure Button4Click(Sender: TObject);
    procedure Button3Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

uses WebCalc.WebServiceCalc;

{$R *.nfm}

procedure TForm1.Button1Click(Sender: TObject);
var
  a, b, c : integer;
  ws : TWebService1;
begin
  ws := TWebService1.Create;

  a := StrToInt(Edit1.Text);
  b := StrToInt(Edit2.Text);

  c := ws.Soma(a,b);

  Edit3.Text := IntToStr(c);
end;

procedure TForm1.Button2Click(Sender: TObject);
var
  a, b, c : integer;
  ws : TWebService1;
begin
  ws := TWebService1.Create;

  a := StrToInt(Edit1.Text);
  b := StrToInt(Edit2.Text);

  c := ws.Subtracao(a,b);

  Edit3.Text := IntToStr(c);
end;

procedure TForm1.Button3Click(Sender: TObject);
var
  a, b, c : integer;
  ws : TWebService1;
begin
  ws := TWebService1.Create;

  a := StrToInt(Edit1.Text);
  b := StrToInt(Edit2.Text);

  c := ws.Produto(a,b);

  Edit3.Text := IntToStr(c);
end;

procedure TForm1.Button4Click(Sender: TObject);
var
  a, b, c : integer;
  ws : TWebService1;
begin
  ws := TWebService1.Create;

  a := StrToInt(Edit1.Text);
  b := StrToInt(Edit2.Text);

  c := ws.Divisao(a,b);

  Edit3.Text := IntToStr(c);
end;

end.
