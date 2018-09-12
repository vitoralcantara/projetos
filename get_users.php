<?php 


error_reporting(-1);
ini_set('display_errors', 'On');

function get_first_user_id(){

    require "conexao_bd.php";

    $first_user_id = null;

    $sql = "SELECT id, nome, mae, pai FROM PESSOAS";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        // output data of each row
        //$res_array = array();
    
        $firstrow = $result->fetch_assoc();
        $first_user_id = $firstrow["id"];
        
        // $i = 0;
        // while($row = $result->fetch_assoc()) {
        //     $res_array[$i]=Array($row["id"],utf8_encode($row["nome"]),utf8_encode($row["mae"]),utf8_encode($row["pai"]));
        //     //echo utf8_encode("id: " . $row["id"]. " - Name: " . $row["nome"]. " " . $row["mae"]. "<br>");
        //     $i++;
        // }

    }
    return $first_user_id;
}


function get_children($person_id){
    require "conexao_bd.php";

    $result = $conn->query("select RELACOES.child_id from RELACOES where RELACOES.person_id =" . $person_id);
    $res_array = array();

    $i = 0;
    while($row = $result->fetch_assoc()) {
        $res_array[i] = $row["child_id"];    
        $i++;
    }
    return $res_array;
}
?>