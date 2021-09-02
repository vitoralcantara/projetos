<%@ Page language="c#" Debug="true" Codebehind="Relatorio.pas" AutoEventWireup="false" Inherits="Relatorio.TRelatorio" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p>
      <asp:TextBox id="t1" runat="server"></asp:TextBox>
      <asp:TextBox id="t2" runat="server"></asp:TextBox>
      <asp:TextBox id="t3" runat="server"></asp:TextBox>
      <asp:TextBox id="t4" runat="server"></asp:TextBox>
      <asp:TextBox id="t5" runat="server"></asp:TextBox>
      <asp:TextBox id="t6" runat="server"></asp:TextBox></p>
      <p>
        <asp:Button id="Button1" runat="server" text="Comparar"></asp:Button>
      </p>
      <asp:Label id="Label1" runat="server" text="Label"></asp:Label>
     </form>
  </body>
</html>
