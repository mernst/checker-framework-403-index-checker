import org.checkerframework.checker.index.qual.IndexFor;
import org.checkerframework.checker.index.qual.IndexOrHigh;
import org.checkerframework.checker.index.qual.IndexOrLow;
import org.checkerframework.checker.index.qual.LTLength;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.index.qual.Unknown;

class TransferAddIndexOrLow {

	
	int[] arr = new int[5];
	int[] arrB = new int[5];
	
	// This error: can be suppressed
	//:: error: (assignment.type.incompatible)
	@IndexOrLow("arr") int i = 2;
	
	void addIndexFor(@IndexFor("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}

	void addIndexOrLow(@IndexOrLow("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}
	
	void addIndexOrHigh(@IndexOrHigh("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}
	
	void add1(@IndexOrHigh("arr") int indexOrHigh1, @IndexOrHigh("arr") int indexOrHigh2) {
		// Show result is of type IndexOrHigh
				@IndexOrHigh("arr") int indexOrHigh = 1 + i;
				//:: error: (assignment.type.incompatible)
				@IndexFor("arr") int indexFor = 1 + i;
	}
	
	void add0() {
		// Show result is of type IndexOrHigh
		@IndexOrLow("arr") int indexOrLow = 0 + i;
        //:: error: (assignment.type.incompatible)
        @IndexFor("arr") int indexFor = 0 + i;
	}
	
	void addLTLength(@LTLength("arr") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}
	
	void addNonNegative(@NonNegative int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}

	void addUnknown(@Unknown int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}

	void addIndexForB(@IndexFor("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}
	
	void addIndexOrLowB(@IndexOrLow("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}

	void addIndexOrHighB(@IndexOrHigh("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}

	void addLTLengthB(@LTLength("arrB") int v) {
		// Show result is of type Unknown
		@Unknown int nn1 = v + i;
		//:: error: (assignment.type.incompatible)
		@NonNegative int nn = v + i;
		//:: error: (assignment.type.incompatible)
		@LTLength("arr") int lTLength = v + i;
	}
}