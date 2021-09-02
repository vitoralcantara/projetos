<%@ Page language="c#" Debug="true" Codebehind="Default.pas" AutoEventWireup="false" Inherits="Default.TDefault" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server"><title></title>
  </head>

  <body>
     <form runat="server">
      <p><strong>Relatório do Cofre
</strong><hr width="100%" size="1"></p>
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
      <p>&nbsp;
</p>
      <div align="center">
      <asp:Panel id="Panel1" runat="server" height="161px" width="536px">
          <P><strong>Gerar Relatório:</strong>
          </P>
          <P align="left">
            <asp:RadioButton id="RadioButton1" runat="server" text="Este mês"></asp:RadioButton>
          </P>
          <P align="left">
            <asp:RadioButton id="RadioButton2" runat="server" text="Dentro do Periodo:"></asp:RadioButton>
          </P>
          <P>
            <table style="WIDTH: 430px; HEIGHT: 147px" bordercolor="tan" cellspacing="1" cellpadding="1" width="430" align="center" bgcolor="lemonchiffon" border="0">
                <tr>
                  <td style="WIDTH: 35px">
                    <p>Entre&nbsp;</p></td>
                  <td style="WIDTH: 88px">
                    <asp:DropDownList id="DDLDiaComeco" runat="server" width="58px"></asp:DropDownList>&nbsp;de</td>
                  <td style="WIDTH: 128px">
                    <asp:DropDownList id="DDLMesComeco" runat="server" width="101px" autopostback="True">
                      <asp:ListItem value="1">Janeiro</asp:ListItem>
                      <asp:ListItem value="2">Fevereiro</asp:ListItem>
                      <asp:ListItem value="3">Mar&#231;o</asp:ListItem>
                      <asp:ListItem value="4">Abril</asp:ListItem>
                      <asp:ListItem value="5">Maio</asp:ListItem>
                      <asp:ListItem value="6">Junho</asp:ListItem>
                      <asp:ListItem value="7">Julho</asp:ListItem>
                      <asp:ListItem value="8">Agosto</asp:ListItem>
                      <asp:ListItem value="9">Setembro</asp:ListItem>
                      <asp:ListItem value="10">Outubro</asp:ListItem>
                      <asp:ListItem value="11">Novembro</asp:ListItem>
                      <asp:ListItem value="12">Dezembro</asp:ListItem>
                    </asp:DropDownList>&nbsp;de </td>
                  <td>
                    <asp:DropDownList id="DDLAnoComeco" runat="server"></asp:DropDownList></td>
                </tr>
                <tr>
                  <td style="WIDTH: 35px">
                    <p>E</p></td>
                  <td style="WIDTH: 88px">
                    <asp:DropDownList id="DDLDiaFim" runat="server" width="58px"></asp:DropDownList>&nbsp;de</td>
                  <td style="WIDTH: 128px">
                    <asp:DropDownList id="DDLMesFim" runat="server" width="101px" autopostback="True">
                      <asp:ListItem value="1">Janeiro</asp:ListItem>
                      <asp:ListItem value="2">Fevereiro</asp:ListItem>
                      <asp:ListItem value="3">Mar&#231;o</asp:ListItem>
                      <asp:ListItem value="4">Abril</asp:ListItem>
                      <asp:ListItem value="5">Maio</asp:ListItem>
                      <asp:ListItem value="6">Junho</asp:ListItem>
                      <asp:ListItem value="7">Julho</asp:ListItem>
                      <asp:ListItem value="8">Agosto</asp:ListItem>
                      <asp:ListItem value="9">Setembro</asp:ListItem>
                      <asp:ListItem value="10">Outubro</asp:ListItem>
                      <asp:ListItem value="11">Novembro</asp:ListItem>
                      <asp:ListItem value="12">Dezembro</asp:ListItem>
                    </asp:DropDownList>&nbsp;de&nbsp; </td>
                  <td>
                    <asp:DropDownList id="DDLAnoFim" runat="server"></asp:DropDownList></td>
                </tr>
            </table>
          </P>
          <P>&nbsp; 
            <asp:Button id="Button1" runat="server" text="Gerar Versão Para Impressão"></asp:Button>
          </P>
      </asp:Panel>
      </div>
      <div align="center">
</div>
      <div align="center">
      <asp:GridView id="GridView1" runat="server" width="192px" backcolor="White" bordercolor="White" borderstyle="Ridge" borderwidth="2px" cellspacing="1" cellpadding="3" gridlines="None">
          <FooterStyle backcolor="#C6C3C6" forecolor="Black"></FooterStyle>
          <RowStyle backcolor="#DEDFDE" forecolor="Black"></RowStyle>
          <SelectedRowStyle backcolor="#9471DE" forecolor="White" font-bold="True"></SelectedRowStyle>
          <PagerStyle backcolor="#C6C3C6" forecolor="Black" horizontalalign="Right"></PagerStyle>
          <HeaderStyle backcolor="#4A3C8C" forecolor="#E7E7FF" font-bold="True"></HeaderStyle></asp:GridView>
      </div>
     </form>
  </body>
</html>
