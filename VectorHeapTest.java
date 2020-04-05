import static org.junit.Assert.*;

class VectorHeapTest {

	@org.junit.Test
    void add() {
        VectorHeap<String> prueba = new VectorHeap<String>();

        prueba.add("Emiliano");
        prueba.add("Ricardo");
        prueba.add("Zaray");
        prueba.add("Esteban");
        prueba.add("Carlos");
        prueba.add("Ayde");

    }

	@org.junit.Test
    void remove() {
        VectorHeap<String> prueba = new VectorHeap<String>();

        prueba.add("Emiliano");
        prueba.add("Ricardo");
        prueba.add("Zaray");
        prueba.add("Esteban");
        prueba.add("Carlos");
        prueba.add("Ayde");

        assertEquals(prueba.remove(),"Ayde");
    }

	@org.junit.Test
    void getFirst() {

        VectorHeap<String> prueba = new VectorHeap<String>();

        prueba.add("Emiliano");
        prueba.add("Ricardo");
        prueba.add("Zaray");
        prueba.add("Esteban");
        prueba.add("Carlos");
        prueba.add("Ayde");

        assertEquals(prueba.getFirst(),"Ayde");
        assertEquals(prueba.getFirst(),"Ayde");

    }

	@org.junit.Test
    void isEmpty() {
        VectorHeap<String> prueba = new VectorHeap<String>();

        prueba.add("Emiliano");
        prueba.add("Ricardo");
        prueba.add("Zaray");
        prueba.add("Esteban");
        prueba.add("Carlos");
        prueba.add("Ayde");

        assertEquals(prueba.isEmpty(),false);

    }
}