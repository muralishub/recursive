import org.scalatest.FunSpec
import org.scalatest.Matchers._

class UltimateSolutionTest extends FunSpec {

  val nodes = Seq(
    Node(1, None),
    Node(1, Some(1)),
    Node(1, Some(2)),
    Node(2, None),
    Node(2, Some(1)),
    Node(3, None),
    Node(3, Some(1)),
    Node(3, Some(2)),
    Node(3, Some(3)) ,
    Node(4, None)
  )



  it("parts grouped togeather") {
    val result = UltimateSolution.aggregateNodes(nodes)

    result  shouldBe  Seq(
      Part(1, Seq(SubPart(1), SubPart(2))),
      Part(2, Seq(SubPart(1))),
      Part(3, Seq(SubPart(1), SubPart(2), SubPart(3))),
      Part(4, Seq())
    )

  }

it("ultimate with empty") {

  val nodes = Seq.empty

  val result = UltimateSolution.ultimateGrouping(nodes)

  result shouldBe Seq.empty

}

  it("ultimate with single node") {

    val nodes = Seq(Node(1, None))

    val result = UltimateSolution.ultimateGrouping(nodes)

    result shouldBe Seq(Part(1, Seq.empty))

  }

  it("ultimate with single node nonempty") {

    val nodes = Seq(Node(1, Some(2)))

    val result = UltimateSolution.ultimateGrouping(nodes)

    result shouldBe Seq(Part(1, Seq(SubPart(2))))

  }

  it("ultimate with 2 nodes") {
    val nodes = Seq(Node(1, Some(1)),
                    Node(1, Some(2)))

    val result = UltimateSolution.ultimateGrouping(nodes)

    result shouldBe Seq(Part(1, Seq(SubPart(1),SubPart(2))))
  }

  it("ultimate with 4 nodes") {
    val nodes = Seq(Node(1, Some(1)),
                   Node(1, Some(2)),
                   Node(1, Some(3)),
                   Node(1, Some(4)))

    val result = UltimateSolution.ultimateGrouping(nodes)

    result shouldBe Seq(Part(1, Seq(SubPart(1),SubPart(2), SubPart(3), SubPart(4))))
  }

  it("ultimate with 2 diff nodes") {
    val nodes = Seq(Node(1, Some(1)),
      Node(1, Some(1)))

    val result = UltimateSolution.ultimateGrouping(nodes)

    result shouldBe Seq(Part(1, Seq(SubPart(1),SubPart(1))))
  }


}
