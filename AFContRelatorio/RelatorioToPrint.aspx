<%@ Page language="c#" Debug="true" Codebehind="RelatorioToPrint.pas" AutoEventWireup="false" Inherits="RelatorioToPrint.TRelatorioToPrint" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p>
        <table style="WIDTH: 465px; HEIGHT: 122px" cellspacing="1" cellpadding="1" width="465" border="1">
            <tr>
              <td><strong>AFContabilidade
</strong></td>
            </tr>
            <tr>
              <td></td>
            </tr>
            <tr>
              <td>Relatório de Contas Entre os dias <asp:Label id="LabelDataInicio" runat="server"></asp:Label>e <asp:Label id="LabelDataFim" runat="server"></asp:Label>


</td>
            </tr>
            <tr>
              <td></td>
            </tr>
        </table>
      </p>
      <p>&nbsp;
</p>
      <p></p>
      <asp:GridView id="GVRelCaixaMovimento" runat="server" backcolor="White" bordercolor="#CCCCCC" borderstyle="None" borderwidth="1px" forecolor="Black" cellpadding="4" gridlines="Horizontal" width="560px">
        <FooterStyle backcolor="#CCCC99" forecolor="Black"></FooterStyle>
        <SelectedRowStyle backcolor="#CC3333" forecolor="White" font-bold="True"></SelectedRowStyle>
        <PagerStyle backcolor="White" forecolor="Black" horizontalalign="Right"></PagerStyle>
        <HeaderStyle backcolor="#333333" forecolor="White" font-bold="True"></HeaderStyle>
      </asp:GridView>
     </form>
  </body>
</html>
