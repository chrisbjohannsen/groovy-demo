package tests

/**
 * Created by chris on 9/25/14.
 */
class ExampleTests extends GroovyTestCase
{
    private workers

    void testSimpleClosure()
    {
        10.times(){ println "Hello from iteration $it"}
    }

    void testMapEach ()
    {
        workers = [Chris: "Footman", Seth: "Butler", Aaron: "Lord's Valet", Jason: "First Footman", Tom: "Lord", Palle: "Valet"]
        workers.each(){ name, occupation -> print "$name is a fine $occupation at Downton Abbey" }
    }

    void testMapCollect ()
    {
        workers = [Chris: "Footman", Seth: "Butler", Aaron: "Lord's Valet", Jason: "First Footman", Tom: "Lord", Palle: "Valet"]
        def actual = workers.collect() { name, occupation -> $name + ":" + $occupation }
        assertTrue(actual.size() == 6)
    }
}
