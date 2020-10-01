<?php

		$con=new mysqli_connect("localhost","root","","artisan-profiling");
//		$con=new mysqli("localhost","root","","artisan-profiling");
	//	$conn=mysqli_connect("localhost","id14527893_root","grB8e0[@rJ[\OOi=","id14527893_artisansprofiling");
//		$conn=mysqli_connect("localhost","root","","artisan-profiling");
		$artlearned=$_GET["artlearned"];
		$hascoworker = $_GET["hascoworker"];
		$noofcoworker = $_GET["noofcoworker"];
		$id = $_GET["id"];
		$artform = $_GET["artform"];

		$st=$con->prepare("UPDATE `extras` SET `artlearned`=? , `hascoworker`=? , `noofcoworker`=? WHERE `artisanid`=?");
		$st->bind_param("ssss", $artlearned, $hascoworker, $noofcoworker, $id);
		$st->execute();


		$query = "SELECT * FROM artform WHERE artFormName='$artform'";
		$result = mysqli_query($con,$query);

		$artformIdd = "";
		if (mysqli_num_rows($result) > 0) {
  // output data of each row
  while($row = mysqli_fetch_assoc($result)) {
  	$artformIdd=$row["id"];
//    echo "id: " . $row["id"];
  }
} else {
  echo "0 results";
}

$st2 =$con->prepare("UPDATE `artisanartformrelation` SET `artFormId`=? WHERE `artisanId`=?");
$st2->bind_param("ss", $artformIdd, $id);
		$st2->execute();


//"INSERT INTO `artisanartformrelation` (artisanId, artFormId) VALUES('" . $id . "', '" . $artformIdd . "')";
//		$result4 = mysqli_query($conn, $st2) ;
		//echo "data uploaded successfully!";
		echo "data uploaded successfully!";
		?>