import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** 
* DifferentialEvolution Tester. 
* 
* @author <Authors name> 
* @since <pre>Jan 14, 2023</pre> 
* @version 1.0 
*/ 
public class DifferentialEvolutionTest {
    private DifferentialEvolution DE;
@Before
public void before() throws Exception {
    DE=new DifferentialEvolution();
    DE.init(3,1,4,4);
}

@After
public void after() throws Exception {
}

/** 
* 
* Method: fun(double param) 
* 
*/


/** 
* 
* Method: init(int order, double ...coef) 
* 
*/ 
@Test(expected = Exception.class)
public void testInitException() throws Exception {
    DE=new DifferentialEvolution();
    DE.init(2,34,554,76);
}

@Test(expected = Test.None.class)
public void testInitGood() throws Exception {
    DE=new DifferentialEvolution();
    DE.init(2,34,554);
}

/** 
* 
* Method: mutate() 
* testam daca s-a modificat v intre 2 mutatii pentru testMutateV, iar la testMutate este verificat daca a fost schimbat size
*/ 
@Test
public void testMutate() throws Exception {
    Assert.assertEquals(80, DE.size);
}
@Test
public void testMutateV() throws Exception {
    DE.mutate();
    DE.mutate();
    double []v= DE.v;
    DE.mutate();
    assertFalse(Arrays.equals(v, DE.v));
}
    /**
* 
* Method: cross_bin() 
*  testam daca s-a modificat u intre 2 incrucisari
*/
@Test
public void testCross_binU() throws Exception {
    DE.cross_bin();
    DE.cross_bin();
    double []u= DE.u;
    DE.cross_bin();
    assertFalse(Arrays.equals(u, DE.u));
} 

/** 
* 
* Method: selection() 
* 
*/ 
@Test
public void testSelection() throws Exception {

} 

/** 
* 
* Method: solve() 
* 
*/ 
@Test
public void testSolve() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: run(int order, double ...coef) 
* 
*/ 
@Test
public void testRun1() throws Exception {
    DE.run(6, 1, -8, -45, 360, 324, -2592);
    assertTrue(Arrays.equals(new double[]{-6,-3,3,6,8},
            Arrays.stream(Arrays.stream(DE.run(6, 1, -8, -45, 360, 324, -2592)).toArray()).sorted().toArray()));
} 


} 
