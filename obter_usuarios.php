<?php
$sql = "SELECT id, nome, mae, pai FROM pessoas";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    $res_array = array();

    $i = 0;
    while($row = $result->fetch_assoc()) {
        $res_array[$i]=Array($row["id"],utf8_encode($row["nome"]),utf8_encode($row["mae"]),utf8_encode($row["pai"]));
        //echo utf8_encode("id: " . $row["id"]. " - Name: " . $row["nome"]. " " . $row["mae"]. "<br>");
        $i++;
    }
}
$conn->close();


function get_children($person_id){
    $result = $conn->query("select relacoes.child_id from relacoes where relacoes.person_id =" . $person_id);
    
    while($row = $result->fetch_assoc()) {
        
    }





}
?>