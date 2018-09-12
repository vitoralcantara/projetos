<?php require_once "conexao_bd.php";
//$username = null;
//$password = null;

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    if(!empty($_POST["username"]) && !empty($_POST["password"])) {
        $username = $_POST["username"];
        $password = $_POST["password"];
  
        $query = $conn->prepare("SELECT `user_id` FROM `users` WHERE `user_login` = ? and `user_password` = PASSWORD(?)");
        
        $query->bind_param("ss", $username, $password);
        $query->execute();
        $query->bind_result($userid);
        $query->fetch();
        $query->close();
        
        if(!empty($userid)) {
            session_start();
            $_SESSION["authenticated"] = 'true';
            header('Location: /index.php');
        }
        else {
            header('Location: /login.php');
        }
        
    } else {
        header('Location: /login.php');
    }
} else {
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Creating a simple to-do application - Part 1</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="arvore_genealogica.css">
</head>
<body>
<div id="page">
    <!-- [banner] -->
    
    <h2>Arvore genealógica da família Alcântara Gregório</h2>
    <hr>
    <h3>Login:</h3>

<!-- [content] -->

    <section id="content">
        <form id="login" method="post">
            <label for="username">Username:</label>
            <input id="username" name="username" type="text" required>
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" required>                    
            <br />
            <input type="submit" value="Login">
        </form>
    </section>
    <!-- [/content] -->

</div>
<!-- [/page] -->
</body>
</html>
<?php } ?>