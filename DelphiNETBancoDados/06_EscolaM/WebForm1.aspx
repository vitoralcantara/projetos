<%@ Page language="c#" Debug="true" Codebehind="WebForm1.pas" AutoEventWireup="false" Inherits="WebForm1.TWebForm1" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p>
        <ASP:Label id="Label1" runat="server">Cadastro de Alunos</ASP:Label>
        <hr width="100%" size="1"></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p>
        <ASP:DataGrid id="DataGrid1" runat="server" datasource="<%# DataTable1 %>" bordercolor="#999999" borderstyle="None" borderwidth="1px" backcolor="White" cellpadding="3" gridlines="Vertical">
          <FooterStyle forecolor="Black" backcolor="#CCCCCC"></FooterStyle>
          <SelectedItemStyle font-bold="True" forecolor="White" backcolor="#008A8C"></SelectedItemStyle>
          <AlternatingItemStyle backcolor="Gainsboro"></AlternatingItemStyle>
          <ItemStyle forecolor="Black" backcolor="#EEEEEE"></ItemStyle>
          <HeaderStyle font-bold="True" forecolor="White" backcolor="#000084"></HeaderStyle>
          <Columns>
            <ASP:ButtonColumn text="Selecionar" commandname="Select"></ASP:ButtonColumn>
            <ASP:ButtonColumn text="Excluir" commandname="Delete"></ASP:ButtonColumn>
          </Columns>
          <PagerStyle horizontalalign="Center" forecolor="Black" backcolor="#999999" mode="NumericPages"></PagerStyle>
        </ASP:DataGrid>
      </p>
      <hr width="100%" size="1">
      <ASP:Button id="Button1" runat="server" text="Inserir Aluno"></ASP:Button>
     </form>
  </body>
</html>
