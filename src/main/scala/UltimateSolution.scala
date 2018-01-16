import scala.annotation.tailrec

object UltimateSolution extends App{

  val nodes = Seq(
    Node(1, None),
    Node(1, Some(1)),
    Node(1, Some(2)),
    Node(2, None),
    Node(2, Some(1)),
    Node(3, None),
    Node(3, Some(1)),
    Node(3, Some(2)),
    Node(3, Some(3))  ,
    Node(4, None)
  )


  val aggregated = Seq(
    Part(1, Seq(SubPart(1), SubPart(2))),
    Part(2, Seq(SubPart(1))),
    Part(3, Seq(SubPart(1), SubPart(2), SubPart(3))),
    Part(4, Seq())
  )


  def aggregateNodes(nodes: Seq[Node]): Seq[Part] = {
    nodes.map(_.part).distinct.map(
      part => {
        val subParts: Seq[Int] = nodes.filter(n => n.part == part).flatMap(_.subPart)
        Part(part, subParts.map(SubPart))
      }
    )
  }

  def ultimateGrouping(nodes: Seq[Node]): Seq[Part] = {

    @tailrec def loop(n: Seq[Node], agg: Seq[SubPart]): Seq[Part] = {
      n match {
        case Nil => Seq.empty
        case h :: Nil if h.subPart == None => Seq(Part(h.part, agg ++ Seq.empty))
        case h :: Nil => Seq(Part(h.part, agg ++ Seq(SubPart(h.subPart.get))))
        case h :: t if h.subPart == None => loop(t, agg ++ Seq.empty)
        case h :: t => loop(t, agg ++ Seq(SubPart(h.subPart.get)))
      }
    }

 //   loop(nodes, Seq.empty)


           def mainLoop(no: Seq[Node], partAgg: Seq[Part], currentNode: Int): Seq[Part] = {

            no match {
              case Nil => Seq.empty
              case h :: Nil if h.part == currentNode => loop(nodes, Seq.empty)
              case h :: t => mainLoop(t, partAgg ++ loop(nodes, Seq.empty), h.part)

            }





         }

      if(nodes.nonEmpty)
        mainLoop(nodes, Seq.empty, nodes.head.part)
        else
        Seq.empty



     }




}

case class Node(part: Int, subPart: Option[Int])

case class Part(value: Int, subParts: Seq[SubPart])
case class SubPart(value: Int)