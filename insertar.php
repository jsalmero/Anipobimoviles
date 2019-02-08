<?php
$email = $_POST['email'];
$name = $_POST['name'];
$header = "Content-Type: application/json";
header($header);
$dbLink = mysqli_connect('localhost','id8465350_root','webservice','id8465350_webservice');
$data = file_get_contents('php://input');
$obtenido = null;
parse_str($data, $obtenido);
if (!$dbLink) {
    $row = array("siteStatus" => "Database Error");
    print json_encode($row);
} else {
     //$query = "SELECT * FROM usuario";
    $query = "INSERT INTO `leccion` (`nombre`) VALUES ('$name');";
    if ($result = mysqli_query($dbLink,$query)) {
       /* $row = $result->fetch_array(MYSQLI_ASSOC);
        if (is_null($row)) {
            $row = array("siteStatus" => "Error - Site Not Found");
        }*/
    } else {
        $row = array("siteStatus" => "General Error");
    }
    print json_encode($row);
    mysqli_close($dbLink);
} // End else condition (for database connection)
?>
