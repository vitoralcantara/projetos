<%@ Page language="c#" Debug="true" Codebehind="WebForm2.pas" AutoEventWireup="false" Inherits="WebForm2.TWebForm2" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p>
        <ASP:Label id="Label1" runat="server">Edi��o de Alunos</ASP:Label>
        <hr width="100%" size="1"></p>
      <p></p>
      <p></p>
      <p></p>
      <p></p>
      <p>
        <table cellspacing="1" cellpadding="1" width="300" border="1">
            <tr>
              <td>Codigo</td>
              <td>
                <ASP:TextBox id="TextBox1" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Nome</td>
              <td>
                <ASP:TextBox id="TextBox2" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Email</td>
              <td>
                <ASP:TextBox id="TextBox3" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Nota Bim 01</td>
              <td>
                <ASP:TextBox id="TextBox4" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Nota Bim 02</td>
              <td>
                <ASP:TextBox id="TextBox5" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Nota Bim 03</td>
              <td>
                <ASP:TextBox id="TextBox6" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td>Nota Bim 04</td>
              <td>
                <ASP:TextBox id="TextBox7" runat="server"></ASP:TextBox></td>
            </tr>
            <tr>
              <td></td>
              <td>
                <ASP:Button id="Button1" runat="server" text="Salvar"></ASP:Button></td>
            </tr>
        </table>
      </p>
     </form>
  </body>
</html>
