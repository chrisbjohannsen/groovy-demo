//simple example

10.times { println("Hello from closure loop number $it")}

//negating "it"
10.times { -> println("Hello from closure loop number $it")} //throws exception cause it is not defined

//multiple parameter closures

workers = [Chris: "Footman", Seth: "Butler", Aaron: "Valet", Jason: "First Footman", Tom: "Lord", Palle: "Driver"]
workers.each(){ name, occupation -> print "$name is a fine $occupation at Downton Abbey" }

/** output
Chris is a fine Footman at Downton Abbey
Seth is a fine Butler at Downton Abbey
Aaron is a fine Valet at Downton Abbey
Jason is a fine First Footman at Downton Abbey
Tom is a fine Lord at Downton Abbey
Palle is a fine Driver at Downton Abbey
**/

// Resource management using the E
/*
def static use(Closure closure)

{
    def r = new Resource()

    try {
        r.Open()
        closure(r)
    } finally {a
        r.close()
    }
}

Resource.use { res ->
    res.Read()
    res.Write()
}
*/