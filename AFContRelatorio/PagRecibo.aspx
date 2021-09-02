<%@ Page language="c#" Debug="true" Codebehind="PagRecibo.pas" AutoEventWireup="false" Inherits="PagRecibo.TPagRecibo" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head runat="server">
    <title></title>
  </head>

  <body>
     <form runat="server">
      <p align="center">&nbsp;</p>
      <p align="center">ESCRITÓRIO DE CONTABILIDADE</p>
      <p align="center">ADRIANA FELICIO DO NASCIMENTO</p>
      <p align="center">&nbsp;</p>
      <p align="center">RECIBO</p>
      <p align="center">
        <asp:Label id="LabelDinheiro" runat="server"></asp:Label>
      </p>
      <p align="center">&nbsp;</p>
      <p align="center">Recebi de 
        <asp:Label id="LabelName" runat="server"></asp:Label>, a importância de R$ 
        <asp:Label id="LabelQuantia" runat="server"></asp:Label>&nbsp;( 
        <asp:Label id="LabelExtenso" runat="server"></asp:Label>), referente a(os) 
        <asp:Label id="LabelAditivo" runat="server"></asp:Label>&nbsp;do(a) 
        <asp:Label id="LabelEmpresas" runat="server"></asp:Label>&nbsp;e honorários pela elaboração dos processos, pelo que passo o presente recibo dando plena e legal quitação.
      </p>
      <p align="center">&nbsp;</p>
      <p align="right">Natal/RN, 
        <asp:Label id="LabelData" runat="server"></asp:Label>
      </p>
      <p align="right">&nbsp;</p>
      <p align="right">ADRIANA FELICIO DO NASCIMENTO</p>
      <p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; CONTADORA</p>
     </form>
  </body>
</html>
