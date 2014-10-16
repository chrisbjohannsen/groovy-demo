/*
**
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
        workers.each(){ name, occupation -> println "$name is a fine $occupation at Downton Abbey" }
    }

    void testMapCollect ()
    {
        workers = [Chris: "Footman", Seth: "Butler", Aaron: "Lord's Valet", Jason: "First Footman", Tom: "Lord", Palle: "Valet"]
        def actual = workers.collect() { name, occupation -> name + " is a " + occupation }
        assertTrue(actual.size() == 6)
        assertEquals(actual[0], "Chris is a Footman")
    }

    void testMOPMethodInterception()
    {
        def myObject = new MyGroovyObject()

        assertEquals(myObject.myOriginalMethod(),'Original Method')

        myObject.metaClass.myOriginalMethod = { -> 'intercepted Original Method'}

        assertEquals(myObject.myOriginalMethod(), 'intercepted Original Method')
    }

    void testMOPMetaclassMethodInjectionOnPOJO(){

        String.metaClass.isPalindrome = {
            -> delegate == delegate.reverse()
        }

        def actual = "radar"

        assertTrue(actual.isPalindrome())
    }
}
