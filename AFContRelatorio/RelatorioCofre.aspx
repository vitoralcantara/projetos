<%@ Page language="c#" Debug="true" Codebehind="RelatorioCofre.pas" AutoEventWireup="false" Inherits="RelatorioCofre.TDefault" %>
<%@ Register TagPrefix="asp" Namespace="System.Web.UI" Assembly="System.Web.Extensions, Version=1.0.61025.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" %>
<%@ Register TagPrefix="asp" Namespace="System.Web.UI" Assembly="System.Web.Extensions, Version=1.0.61025.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p><strong><asp:HyperLink id="HyperLink2" runat="server" navigateurl="PagRecibo.aspx">Ir Para Página do Recibo
</asp:HyperLink>&nbsp;<asp:HyperLink id="HyperLink1" runat="server" navigateurl="RelatorioCaixa.aspx">Ir Para Página do RelatórioCaixa
</asp:HyperLink>












</strong></p></strong>
      <p></p><strong>Relatório do Cofre
</strong>
        <hr width="100%" size="1">
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
        <asp:Label id="LabelAlerta" runat="server" text="Label"></asp:Label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 


</p>
      <div align="center">
        <table cellspacing="1" cellpadding="1" width="300" align="left" border="0">
            <tr>
              <td>
      <p align="left"><asp:RadioButton id="RBPeriodo" runat="server" text="No Período:"></asp:RadioButton></p>
      <p align="left">
        <asp:RadioButton id="RBMes" runat="server" text="Do Início do Mês até Hoje" checked="True"></asp:RadioButton></p>
      <p align="left">
                <table cellspacing="1" cellpadding="1" width="300" align="center" border="0">
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
                        <asp:Calendar id="CalendarEntrada" runat="server" width="187px" height="29px" bordercolor="#999999" cellpadding="4" font-size="8pt" font-names="Verdana" backcolor="White" daynameformat="Shortest" forecolor="Black">
                          <SelectedDayStyle backcolor="#666666" forecolor="White" font-bold="True"></SelectedDayStyle>
                          <TodayDayStyle backcolor="#CCCCCC" forecolor="Black"></TodayDayStyle>
                          <SelectorStyle backcolor="#CCCCCC"></SelectorStyle>
                          <WeekendDayStyle backcolor="#FFFFCC"></WeekendDayStyle>
                          <OtherMonthDayStyle forecolor="#808080"></OtherMonthDayStyle>
                          <NextPrevStyle verticalalign="Bottom"></NextPrevStyle>
                          <DayHeaderStyle backcolor="#CCCCCC" font-size="7pt" font-bold="True"></DayHeaderStyle>
                          <TitleStyle backcolor="#999999" bordercolor="Black" font-bold="True"></TitleStyle>
                        </asp:Calendar></td>
                      <td>
                        <asp:Calendar id="CalendarSaida" runat="server" width="189px" height="155px" bordercolor="#999999" cellpadding="4" font-size="8pt" font-names="Verdana" backcolor="White" daynameformat="Shortest" forecolor="Black">
                          <SelectedDayStyle backcolor="#666666" forecolor="White" font-bold="True"></SelectedDayStyle>
                          <TodayDayStyle backcolor="#CCCCCC" forecolor="Black"></TodayDayStyle>
                          <SelectorStyle backcolor="#CCCCCC"></SelectorStyle>
                          <WeekendDayStyle backcolor="#FFFFCC"></WeekendDayStyle>
                          <OtherMonthDayStyle forecolor="#808080"></OtherMonthDayStyle>
                          <NextPrevStyle verticalalign="Bottom"></NextPrevStyle>
                          <DayHeaderStyle backcolor="#CCCCCC" font-size="7pt" font-bold="True"></DayHeaderStyle>
                          <TitleStyle backcolor="#999999" bordercolor="Black" font-bold="True"></TitleStyle>
                        </asp:Calendar></td>
                    </tr>
                </table></p></td>
              <td>
      <p align="left">
                  <table cellspacing="1" cellpadding="1" width="300" border="1">
                      <tr>
                        <td>
                <asp:RadioButton id="RadioButton1" runat="server" width="179px" text="Saldo Positivo e Negativo"></asp:RadioButton></td>
                      </tr>
                      <tr>
                        <td>
                <asp:RadioButton id="RadioButton2" runat="server" width="158px" text="Apenas Saldo Positivo"></asp:RadioButton></td>
                      </tr>
                      <tr>
                        <td><asp:RadioButton id="RadioButton3" runat="server" width="169px" text="Apenas Saldo Negativo"></asp:RadioButton></td>
                      </tr>
                  </table></p></td>
              <td></td>
            </tr>
            <tr>
              <td>
              <asp:Button id="Button2" runat="server" text="Realizar Pesquisa" font-bold="False" font-italic="False" font-names="ararial" font-overline="False" font-size="Smaller" font-underline="False" font-strikeout="False" forecolor="Black"
                          borderstyle="Solid" bordercolor="Red" backcolor="Gainsboro"></asp:Button>
              <asp:Button id="Button1" runat="server" text="Gerar Relatório"></asp:Button></td>
              <td>&nbsp; 
</td>
              <td></td>
            </tr>
        </table>
      </div>
      <div align="center">
</div>
      <div align="center">
</div>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 



</p>
      <p>
</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</p>
      <p>
</p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 


</p>
      <p>
</p>
      <p>
</p>
      <p>
</p>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
</div>
      <div align="center">
        <asp:GridView id="GridView1" runat="server" width="462px" forecolor="Black" borderstyle="Solid" bordercolor="#999999" backcolor="#CCCCCC" borderwidth="3px" cellspacing="2" cellpadding="4">
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
    <p>&nbsp;
</p>
  </body>
</html>
