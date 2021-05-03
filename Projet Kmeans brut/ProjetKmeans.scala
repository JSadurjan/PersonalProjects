import scala.io.Source
import scala.util.Random

object ProjetKmeans{
  def main(args: Array[String]){
    /*---------------------------------------
        Extraction du fichier en question
    ---------------------------------------*/
    var ListeDesIris : List[List[String]] = List()
    val l = Source.fromFile("C:\\Users\\Sad Jeyakumar\\IdeaProjects\\Kmeans\\src\\main\\scala\\iris.data")
    val ll = l.getLines
    for(ligne <- ll){
      val listTemp = ligne.split(",").toList
      ListeDesIris = listTemp :: ListeDesIris
    }
    l.close()

    /*println(ListeDesIris)
    println("la taille de la liste est de "+ListeDesIris.length+"\n")*/

    /*println("La covariance des caractères 1 et 2 est : "+coVarianceCaractere(ListeDesIris,0,1))
    println("Le coefficient de corrélation entre les caractères 1 et 2 est : "+coefficientCorrelation(ListeDesIris,0,1))
    println("\n")*/

    println("On initialise les clusters. \n")

    val cluster = new ClusterKmean(ListeDesIris,0, 5)

    cluster.initialisation()
    cluster.affichage_centres()
    var derniersCentres : List[Point] = cluster.Centres()
    var a = false
    var i = 0
    while(!a ){
      println(s"\n Assignation n°$i \n")
      cluster.affectation()
      cluster.affichage_centres()
      a = true
      val nouvCentres : List[Point]= cluster.Centres()
      for(j <- nouvCentres.indices){
        a = a && nouvCentres(j).egal(derniersCentres(j))
      }
      derniersCentres = nouvCentres
      i += 1
    }
    println("\n L'algorithme s'arrête ici parce qu'il n'y a plus de changement de centres." +
      " Les données sont ainsi stabilisées.")
  }

  def moyenneCaractere(matrice : List[List[String]], caractere : Int) : Double = {
    var moyenne : Double = 0
    for(l <- matrice ){
      moyenne += l(caractere).toDouble
    }
    moyenne = moyenne /matrice.length
    moyenne
  }

  def varianceCaractere(matrice : List[List[String]], caractere : Int) : Double = {
    val moyenne : Double = moyenneCaractere(matrice, caractere)
    var variance : Double = 0
    for(l <- matrice ){
      variance += (l(caractere).toDouble - moyenne)*(l(caractere).toDouble - moyenne)
    }
    variance = variance /matrice.length
    variance
  }

  def ecartTypeCaractere(matrice : List[List[String]], caractere : Int) : Double = {
    Math.sqrt(varianceCaractere(matrice,caractere))
  }
  def coVarianceCaractere(matrice : List[List[String]], caractere1 : Int, caractere2 : Int) : Double = {
    val moyenne1 : Double = moyenneCaractere(matrice, caractere1)
    val moyenne2 : Double = moyenneCaractere(matrice, caractere2)
    var coVariance : Double = 0
    for(l <- matrice ){
      coVariance += (l(caractere1).toDouble - moyenne1)*(l(caractere2).toDouble - moyenne2)
    }
    coVariance = coVariance /matrice.length
    coVariance
  }

  def coefficientCorrelation(matrice : List[List[String]], caractere1 : Int, caractere2 : Int) : Double = {
    coVarianceCaractere(matrice,caractere1,caractere2)/
      ecartTypeCaractere(matrice,caractere1)* ecartTypeCaractere(matrice,caractere2)
  }
}

class Cluster(var listePoints : List[Point], var centre : Point = new Point()){
  def centrer() : Unit = {
    var x : Double =0
    var y : Double =0
    for(p <- listePoints){
      x+=p.x
      y+=p.y
    }
    this.centre = new Point(x/this.listePoints.size,y/this.listePoints.size)
  }

  def ajout(p : Point) : Unit = {
    this.listePoints = p :: this.listePoints
  }
}

class Point(val x : Double = 0, val y : Double = 0){
  def distanceEuclidienne(p: Point) : Double = Math.sqrt((this.x - p.x)*(this.x - p.x)+(this.y - p.y)*(this.y - p.y))
  override def toString: String = {s"($x, $y)"}
  def egal(p : Point) : Boolean = {
    this.x == p.x && this.y == p.y
  }
}

class ClusterKmean(var ListeD : List[List[String]], indice : Int = 0 , val k : Int =2 ) {
  var clusters: List[Cluster] = List()

  def initialisation(): Unit = {
    this.ListeD = Random.shuffle(this.ListeD)
    val lesCentres = this.ListeD.take(k)
    for (l <- lesCentres) {
      this.clusters = new Cluster(List(), extraction_coord(l, indice)) :: this.clusters
    }
  }

  def extraction_coord(l: List[String], indice: Int = 0): Point = {
    require(indice <= 1, " L'indice est invalide !")
    val x = l(indice).toDouble
    val y = l(indice + 1).toDouble
    new Point(x, y)
  }

  def affichage_centres(): Unit = {
    var i = 1
    for (cluster <- clusters) {
      println("Le cluster " + i + " a pour nouveau centre le point de coordonnées " + cluster.centre +
        ". Il contient " + cluster.listePoints.size + " Iris.")
      i = i + 1
    }
  }

  def affectation(): Unit = {
    for (c <- this.clusters) {
      c.listePoints = List()
    }
    for (l <- this.ListeD) {
      val pointl = extraction_coord(l, this.indice)
      var ind = 0
      var dist: Double = 10000000
      for (i <- 0 until this.k) {
        val dist2: Double = this.clusters(i).centre.distanceEuclidienne(pointl)
        if (dist2 < dist || dist2.isNaN) {
          ind = i
          dist = dist2
        }
      }

      this.clusters(ind).ajout(pointl)
    }
    for (cluster <- clusters) {
      cluster.centrer()
    }
  }

  def Centres(): List[Point] = {
    var Centres: List[Point] = List()
    for (cluster <- clusters) {
      Centres = cluster.centre :: Centres
    }
    Centres
  }
}