/*
**
* Created by chris on 9/25/14.
*/
class ExampleTests extends GroovyTestCase
{
    private workers = [William: "Footman", Charlie: "Butler", John: "Lord's Valet", Thomas: "First Footman", Robert: "Lord", Tom: "Chauffer"]

    void testFailure()
    {
        fail("This test is broken")
    }

    /* Basic Closure Tests */
    void testSimpleClosure()
    {
        10.times(){ println "Hello from iteration $it"}
    }


    /* Collections Tests*/
    void testMapEach ()
    {
        workers.each(){ name, occupation -> println "$name is a fine $occupation at Downton Abbey" }
    }

    void testMapCollect ()
    {
        def actual = workers.collect() { name, occupation -> name + " is a " + occupation }
        assertTrue(actual.size() == 6)
        assertEquals(actual[0], "William is a Footman")
    }

    void testMapFind ()
    {
        def actual = workers.find { it.key ==  "John" }
        assertEquals(actual.value, "Lord's Valet")
    }

    void testMapFindAll()
    {
        def actual = workers.findAll {it.value.contains("a")}
        assertEquals(actual.size(), 4)
    }

    void testMapAny()
    {
        def actual = workers.any { it.key == "Tom" }
        assertTrue(actual)
    }

    void testMapEvery()
    {
        def actual = workers.every { it.key.size() > 0 }
        assertTrue(actual)
    }

    void testMapGroupBy() {
        def offices = [
                new MyGroovyObject(name: "AELN", prop1: "Bend", prop2: "Oregon"),
                new MyGroovyObject(name: "HQ", prop1: "San Diego", prop2: "California"),
                new MyGroovyObject(name: "Foundation", prop1: "San Diego", prop2: "California"),
                new MyGroovyObject(name: "PLP", prop1: "San Diego", prop2: "California"),
                new MyGroovyObject(name: "LIMS", prop1: "Milford", prop2: "Massachusetts"),
                new MyGroovyObject(name: "LES", prop1: "Milford", prop2: "Massachusetts"),
                new MyGroovyObject(name: "Discoverant", prop1: "Boulder", prop2: "Colorado"),
                new MyGroovyObject(name: "MakeBelieve", prop1: "Boulder", prop2: "Wyoming"),
        ]

        def byCity = offices.groupBy { office -> office.prop1 }

        byCity.each {println it}
        assertTrue byCity["Bend"].size() == 1
        assertTrue byCity["Boulder"].size() == 2
        assertTrue byCity["Milford"].size() == 2
        assertTrue byCity["San Diego"].size() == 3

        def plp = offices.find{ it.name == "PLP" }
        assertTrue(byCity["San Diego"].contains(plp))
        assertTrue( byCity["Boulder"].find{ it.name == "Discoverant"}.prop2 == "Colorado" )
    }

    /* MetaObjectClass Tests*/
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

    /*  Mocking  */

}
