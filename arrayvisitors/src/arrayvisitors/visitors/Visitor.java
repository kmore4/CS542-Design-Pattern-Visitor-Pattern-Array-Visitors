package arrayvisitors.visitors;

import java.io.IOException;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;
import arrayvisitors.validations.UndefinedBehaviourException;

public interface Visitor {
	
	void visit(MyArrayI arr) throws UndefinedBehaviourException, IOException;
    void visit(MyArrayListI list1) throws UndefinedBehaviourException;

}
