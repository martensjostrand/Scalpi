package scalpi

trait ProblemSolver{ 
  def solve(description: ProblemDescription): ProblemSolution
}
