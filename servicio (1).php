<?php
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
     $query = "SELECT * FROM leccion";
    //$query = "INSERT INTO leccion VALUES (1, Ronny)";
    if ($result = mysqli_query($dbLink,$query)) {
        $row = $result->fetch_array(MYSQLI_ASSOC);
        if (is_null($row)) {
            $row = array("siteStatus" => "Error - Site Not Found");
        }
    } else {
        $row = array("siteStatus" => "General Error");
    }
    print json_encode($row);
    mysqli_close($dbLink);
} // End else condition (for database connection)
?>
