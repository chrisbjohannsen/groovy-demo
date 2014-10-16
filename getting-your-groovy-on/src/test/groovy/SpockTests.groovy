import spock.lang.Specification

/**
 * Created by chris on 10/4/14.
 */
class SpockTests extends Specification {

    def "Groovy Map.collect example"()
    {
        setup:
        def workers = [Chris: "Footman", Seth: "Butler", Aaron: "Lord's Valet", Jason: "First Footman", Tom: "Lord", Palle: "Valet"]

        when:
        def actual = workers.collect() { name, occupation -> "$name is a fine $occupation at Downton Abbey" }

        then:
        actual.size() == 6
        actual[0] == "Chris is a fine Footman at Downton Abbey"
    }

    def "Groovy Map.each example"()
    {
        setup:
        def workers = [Chris: "Footman", Seth: "Butler", Aaron: "Lord's Valet", Jason: "First Footman", Tom: "Lord", Palle: "Valet"]
        def actual = []
        when:

        workers.each(){ entry -> actual << "$entry.key is a fine $entry.value at Downton Abbey" }

        then:
        actual.size() == 6
        actual[0] == "Chris is a fine Footman at Downton Abbey"
    }

    def "Groovy times example"()
    {
        setup:
        def counter = 0;
        when:
        10.times { counter++}
        then:
        counter == 10;
    }

    def "Groovy Step example"()
    {
        setup:
        def counter = 0
        when:
        0.step(10,2,{ counter ++ })
        then:
        counter == 5
    }
}