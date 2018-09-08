<!DOCTYPE html>
<html>
<body>

<h2>Insira uma pessoa</h2>

<form action="/inserir_pessoa_DAO.php" method="post">
  Nome da pessoa:<br>
  <input type="text" name="nomedapessoa" value="">
  <br>
  Nome da mãe:<br>
  <input type="text" name="nomedamae" value="">
  <br>
  Nome do pai:<br>
  <input type="text" name="nomedopai" value="">
  <br>
  <br>
  <input type="button" value="Cancelar" onclick="history.back()"> <input type="submit" value="Adicionar">
</form>

</body>
</html>