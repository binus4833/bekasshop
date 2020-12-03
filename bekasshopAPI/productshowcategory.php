<?php
require_once ("config.php");

if($_SERVER['REQUEST_METHOD']=='POST') {
    
    $category = $_POST['category'];

    $sql = "SELECT * FROM products WHERE category='$category'";
    $query = mysqli_query($con, $sql);

    $result = array();

    while($row = mysqli_fetch_assoc($query) ){
        
        array_push($result,
        array(
            'id' => $row['id'],
            'name' => $row['name'],
            'description' => $row['description'],
            'image' => $row['image'],
            'price' => $row['price'])
        );
    }
    echo json_encode(array("products"=>$result));
    mysqli_close($con);
}
?>