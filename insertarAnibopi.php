<?php
$aciertoAni = $_POST['acierto'];
$equivocacionAni = $_POST['equivocacion'];

//$acierto =6;
//$equivocacion=7;

$header = "Content-Type: application/json";
header($header);
$dbLink = mysqli_connect('localhost','id8465350_rsabando','webservice','id8465350_anibopi');
$data = file_get_contents('php://input');
$obtenido = null;
parse_str($data, $obtenido);
if (!$dbLink) {
    $row = array("siteStatus" => "Database Error");
    print json_encode($row);
} else {
    $sql = ("SELECT * FROM datos WHERE id='1' ");
   $consulta =mysqli_query($dbLink,$sql);

if($consulta){

 $row = $consulta->fetch_array(MYSQLI_ASSOC);
     echo "Base:  ";
    //echo $row["clicjugar"];
     //echo $row["lleganlonchera"];
   $acierto = $row["acierto"]+$aciertoAni;
    $equivocacion = $row["equivocacion"]+$equivocacionAni;
   
    $query = "UPDATE datos SET acierto = '$acierto', equivocacion = '$equivocacion' WHERE id = 1";
     $result = mysqli_query($dbLink,$query);
    echo "Actualizando...";

}

   
     
  //  print json_encode($row);
    mysqli_close($dbLink);
} // End else condition (for database connection)
?>
