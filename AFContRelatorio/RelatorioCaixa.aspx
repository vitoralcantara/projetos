<%@ Page language="c#" Debug="true" Codebehind="RelatorioCaixa.pas" AutoEventWireup="false" Inherits="RelatorioCaixa.TRelatorioCaixa" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p>Relat�rioCofre
</p>
      <div style="DISPLAY: inline; WIDTH: 70px; POSITION: relative; HEIGHT: 15px" ms_positioning="FlowLayout">Label
</div>
      <p>
        <hr width="100%" size="1"></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p>
</p>
      <p>
        <asp:Label id="LabelAlerta" runat="server"></asp:Label>
      </p>
    <p>
      <asp:RadioButton id="RBMes" runat="server" text="Do Inicio do M�s at� Hoje" checked="True" groupname="Selecao"></asp:RadioButton>
    </p>
    <p>
      <asp:RadioButton id="RBPeriodo" runat="server" text="Dentro do Per�odo" groupname="Selecao"></asp:RadioButton>
    </p>
      <p>Gerar Relat�rio: 
</p>
      <p>
        <table style="WIDTH: 485px; HEIGHT: 233px" cellspacing="1" cellpadding="1" width="485" align="center" border="1">
            <tr>
              <td>
                <p align="center">Entre
</p></td>
              <td>
                <p align="center">E
</p></td>
            </tr>
            <tr>
              <td>
                <asp:Calendar id="CalendarEntrada" runat="server"></asp:Calendar></td>
              <td>
                <asp:Calendar id="CalendarSaida" runat="server"></asp:Calendar></td>
            </tr>
        </table>
</p>
      <p></p>
      <table cellspacing="1" cellpadding="1" width="300" align="center" border="1">
          <tr>
            <td>
              <asp:Button id="Button1" runat="server" text="Exibir Caixas"></asp:Button></td>
            <td>
              <asp:Button id="Button2" runat="server" text="Gerar Relat�rio"></asp:Button></td>
          </tr>
      </table>
      <div align="center">
      <asp:GridView id="GridView1" runat="server" bordercolor="#999999" cellpadding="4" width="464px" borderwidth="3px" backcolor="#CCCCCC" height="152px" forecolor="Black" borderstyle="Solid" cellspacing="2">
        <FooterStyle backcolor="#CCCCCC"></FooterStyle>
        <RowStyle backcolor="White"></RowStyle>
        <SelectedRowStyle backcolor="#000099" forecolor="White" font-bold="True"></SelectedRowStyle>
        <PagerStyle backcolor="#CCCCCC" forecolor="Black" horizontalalign="Left"></PagerStyle>
        <HeaderStyle backcolor="Black" forecolor="White" font-bold="True"></HeaderStyle>
      </asp:GridView>
      </div>
     </form>
    <p>&nbsp;
</p>
    <p>
</p>
    <p>
</p>
    <p>
</p>
  </body>
</html>
