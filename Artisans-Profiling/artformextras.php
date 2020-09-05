<?php

		$con=new mysqli("localhost","root","","artisan-profiling");
		$conn=mysqli_connect("localhost","root","","artisan-profiling");
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

$st2 = "INSERT INTO `artisanartformrelation` (artisanId, artFormId) VALUES('" . $id . "', '" . $artformIdd . "')";
		$result4 = mysqli_query($conn, $st2) ;
		//echo "data uploaded successfully!";
		echo "data uploaded successfully!";
		?>
