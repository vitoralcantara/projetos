<%@ Page language="c#" Debug="true" Codebehind="RelatorioCaixas.pas" AutoEventWireup="false" Inherits="RelatorioCaixas.TRelatorioCaixas" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <table cellspacing="1" cellpadding="1" width="300" border="0">
          <tr>
            <td>Relatório do Caixa 
</td>
          </tr>
      </table>
      <asp:Label id="Label1" runat="server" text="Label"></asp:Label>
      <p></p>
      <table cellspacing="1" cellpadding="1" width="483" border="0" style="WIDTH: 483px; HEIGHT: 385px">
          <tr>
            <td>
      <table cellspacing="1" cellpadding="1" width="300" border="0">
          <tr>
            <td>
              <asp:RadioButton id="RadioButton1" runat="server" text="Caixa Atual" groupname="SelecaoCaixa" checked="True"></asp:RadioButton></td>
            <td style="WIDTH: 7px">
              <asp:CheckBox id="CBEntrada" runat="server" text="Entradas" width="109px" checked="True"></asp:CheckBox></td>
          </tr>
          <tr>
            <td>
              <asp:RadioButton id="RadioButton2" runat="server" text="Caixa do Dia:" groupname="SelecaoCaixa"></asp:RadioButton></td>
            <td style="WIDTH: 7px">
              <asp:CheckBox id="CBSaida" runat="server" text="Saidas" checked="True"></asp:CheckBox></td>
          </tr>
          <tr>
            <td>
              <asp:Calendar id="Calendar1" runat="server" bordercolor="#999999" cellpadding="4" width="189px" font-size="8pt" font-names="Verdana" backcolor="White" daynameformat="Shortest" height="83px" forecolor="Black">
                <SelectedDayStyle backcolor="#666666" forecolor="White" font-bold="True"></SelectedDayStyle>
                <TodayDayStyle backcolor="#CCCCCC" forecolor="Black"></TodayDayStyle>
                <SelectorStyle backcolor="#CCCCCC"></SelectorStyle>
                <WeekendDayStyle backcolor="#FFFFCC"></WeekendDayStyle>
                <OtherMonthDayStyle forecolor="#808080"></OtherMonthDayStyle>
                <NextPrevStyle verticalalign="Bottom"></NextPrevStyle>
                <DayHeaderStyle backcolor="#CCCCCC" font-size="7pt" font-bold="True"></DayHeaderStyle>
                <TitleStyle backcolor="#999999" bordercolor="Black" font-bold="True"></TitleStyle>
              </asp:Calendar></td>
            <td style="WIDTH: 7px">
              <div align="center">
                <asp:Button id="Button1" runat="server" text="Pesquisar" width="157px"></asp:Button>
              </div>
              <asp:Button id="Button3" runat="server" text="Gerar Relatório" width="155px"></asp:Button></td>
          </tr>
      </table></td><td>
              <table cellspacing="1" cellpadding="1" width="300" border="0">
                  <tr>
                    <td><strong>Dados do Extrato:
</strong></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Pago: 
</td>
                    <td>
                      <asp:Label id="LabelExtPago" runat="server"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Data de Pagamento:
</td>
                    <td>
                      <asp:Label id="LabelExtData" runat="server"></asp:Label></td>
                  </tr>
              </table>
              <table cellspacing="1" cellpadding="1" width="300" border="0">
                  <tr>
                    <td style="HEIGHT: 21px"><strong>Dados da Parcela:
</strong></td>
                    <td style="HEIGHT: 21px"></td>
                  </tr>
                  <tr>
                    <td>Nº Parcela:
</td>
                    <td>
                      <asp:Label id="Label13" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Data de Vencimento:
</td>
                    <td>
                      <asp:Label id="Label12" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Valor da Parcela:
</td>
                    <td>
                      <asp:Label id="Label11" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Valor Pago:
</td>
                    <td>
                      <asp:Label id="Label10" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td>
                      <asp:Label id="Label9" runat="server" text="Label"></asp:Label></td>
                  </tr>
              </table>
              <table cellspacing="1" cellpadding="1" width="300" border="0">
                  <tr>
                    <td><strong>Dados da Conta:
</strong></td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>Descrição:
</td>
                    <td>
                      <asp:Label id="Label2" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Empresa:
</td>
                    <td>
                      <asp:Label id="Label3" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Receita ou Despesa:
</td>
                    <td>
                      <asp:Label id="Label4" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Data de Criação:
</td>
                    <td>
                      <asp:Label id="Label5" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Funcionário Responsável:
</td>
                    <td>
                      <asp:Label id="Label6" runat="server" text="Label"></asp:Label></td>
                  </tr>
                  <tr>
                    <td>Situação:
</td>
                    <td>
                      <asp:Label id="Label7" runat="server" text="Label"></asp:Label></td>
                  </tr><tr>
                    <td>Número de Parcelas:
</td>
                    <td>
                      <asp:Label id="Label8" runat="server" text="Label"></asp:Label></td>
                  </tr>
              </table></td>
          </tr>
          <tr>
            <td></td>
            <td></td>
          </tr>
      </table>
      <asp:GridView id="GridView1" runat="server" bordercolor="#999999" cellpadding="4" width="592px" backcolor="#CCCCCC" height="199px" borderstyle="Solid" borderwidth="3px" cellspacing="2" forecolor="Black" horizontalalign="Center" emptydatatext="Não Ha Contas nesse Dia">
        <FooterStyle backcolor="#CCCCCC"></FooterStyle>
        <Columns>
          <asp:CommandField selecttext="Detalhes" showselectbutton="True"></asp:CommandField>
        </Columns>
        <RowStyle backcolor="White"></RowStyle>
        <SelectedRowStyle backcolor="#000099" forecolor="White" font-bold="True"></SelectedRowStyle>
        <PagerStyle backcolor="#CCCCCC" forecolor="Black" horizontalalign="Left"></PagerStyle>
        <HeaderStyle backcolor="Black" forecolor="White" font-bold="True"></HeaderStyle>
      </asp:GridView>
</form>
    <p>&nbsp;
</p>
    <p>&nbsp;
</p>
    <p>&nbsp;
</p>
  </body>
</html>
