abstract class Employee(
    var fullName: String,
    var experience: Int,
    var baseSalary: Double
) {
    open fun giveSalary(): Double {
        if (experience > 2 && experience < 5 ) return baseSalary + 200.0
        if (experience > 5) return baseSalary * 1.2 + 500.0
        return baseSalary
    }
    
}
class Developer(
    fullName: String,
    experience: Int,
    baseSalary: Double
) : Employee(fullName, experience, baseSalary)
class Designer(
    fullName: String,
    experience: Int,
    baseSalary: Double,
    var coeficient: Double
) : Employee(fullName, experience, baseSalary) {
    override fun giveSalary(): Double {
        
        return super.giveSalary() * coeficient
    }
}
class Manager(
    fullName: String,
    experience: Int,
    baseSalary: Double,
    var team: MutableList<Employee> = mutableListOf()
) : Employee(fullName, experience, baseSalary) {
    override fun giveSalary(): Double {
        var DevCount = team.filterIsInstance<Developer>().count()
        var DesCount = team.filterIsInstance<Designer>().count()
        var TeamCount =  DesCount + DevCount
        if (TeamCount > 5 && TeamCount < 10)  return super.giveSalary() + 200.0
        if (TeamCount > 10) return super.giveSalary() + 300.0
        if (DevCount > TeamCount/2) return super.giveSalary() * 1.1
        return super.giveSalary()
    }
}
class Department(
    var managers: MutableList<Manager> = mutableListOf()
) {
    fun giveAllSalary() {
        managers.forEach{manager -> manager.giveSalary()
        manager.team.forEach{employee -> employee.giveSalary()
                }
            }
        }
    }

fun main() {
    val manager1 = Manager("Hazel Jones", 10, 55830.0)
    val dev1 = Developer("Eleanor Rhodes", 14, 74.0)
    manager1.team.add(dev1)
    val dev2 = Developer("Martha Long", 20,5857542420.0)
    manager1.team.add(dev2)
    val dev3 = Developer("Cody Fleming", 17, 1.0)
    manager1.team.add(dev3)
    val dev4 = Developer("Cindy Clark", 16, 10.0)
    manager1.team.add(dev4)
    val des1 = Designer("Melissa Smith", 2, 7530.0, 0.9999)
    manager1.team.add(des1)
    val manager2 = Manager("Mamkin Sun", 1, 7400.0)
    val dev5 = Developer("Leonardo Di Capriz", 2,7410.0)
    manager2.team.add(dev5)
    val dev6 = Developer("Scott Miller", 2, 85200.0)
    manager2.team.add(dev6)
        val dev7 = Developer("Denise Campbell", 4, 35750.0)
    manager2.team.add(dev7)
    val des2 = Designer("Lionel Messi", 50, 4500.0, 0.42)
    manager2.team.add(des2)
    val des3 = Designer("Zinaida Zimulin", 4, 5000.0, 0.369821)
    manager2.team.add(des3)
    val des4 = Designer(" Max Petuh", 6, 1000.0, 0.58262)
    manager2.team.add(des4)
    val department = Department()
    department.giveAllSalary()
    println(dev1.fullName + " got salary: " + dev1.giveSalary())
    println(dev2.fullName + " got salary: " + dev2.giveSalary())
    println(dev3.fullName + " got salary: " + dev3.giveSalary())
    println(dev4.fullName + " got salary: " + dev4.giveSalary())
    println(dev5.fullName + " got salary: " + dev5.giveSalary())
    println(dev6.fullName + " got salary: " + dev6.giveSalary())
    println(dev7.fullName + " got salary: " + dev7.giveSalary())
    println(des1.fullName + " got salary: " + des1.giveSalary())
    println(des2.fullName + " got salary: " + des2.giveSalary())
    println(des3.fullName + " got salary: " + des3.giveSalary())
    println(des4.fullName + " got salary: " + des4.giveSalary())
    println(manager1.fullName + " got salary: " + manager1.giveSalary())
    println(manager2.fullName + " got salary: " + manager2.giveSalary())
}