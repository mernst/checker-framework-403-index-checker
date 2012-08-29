import checkers.nullness.NullnessUtils;
import checkers.nullness.quals.*;

class TestNullnessUtils {
    void testRef1(@Nullable Object o) {
        // one way to use as a cast:
        @NonNull Object l1 = NullnessUtils.castNonNull(o);
    }

    void testRef2(@Nullable Object o) {
        // another way to use as a cast:
        NullnessUtils.castNonNull(o).toString();
    }

    void testRef3(@Nullable Object o) {
        // one way to use as a statement:
        NullnessUtils.castNonNull(o);
        o.toString();
    }

    void testArr1(@Nullable Object @NonNull [] a) {
        // one way to use as a cast:
        @NonNull Object [] l1 = NullnessUtils.castNonNull(a);
    }

    void testArr2(@Nullable Object @NonNull [] a) {
        // another way to use as a cast:
        NullnessUtils.castNonNull(a)[0].toString();
    }

    /*
    // TODO: flow does not propagate component types.
    void testArr3(@Nullable Object @NonNull [] a) {
        // one way to use as a statement:
        NullnessUtils.castNonNull(a);
        a[0].toString();
    }
    */

    void testMultiArr1(@Nullable Object @NonNull [] @Nullable [] a) {
        //:: error: (assignment.type.incompatible) :: error: (accessing.nullable)
        @NonNull Object l1 = a[0][0];
        // one way to use as a cast:
        @NonNull Object [] [] l2 = NullnessUtils.castNonNull(a);
    }

    void testMultiArr2(@Nullable Object @NonNull [] @Nullable [] a) {
        // another way to use as a cast:
        NullnessUtils.castNonNull(a)[0][0].toString();
    }

    void testMultiArr3(@Nullable Object @Nullable [] @Nullable [] @Nullable [] a) {
        //:: error: (dereference.of.nullable) :: error: (accessing.nullable)
        a[0][0][0].toString();
        // another way to use as a cast:
        NullnessUtils.castNonNull(a)[0][0][0].toString();
    }

    public static void main(String[] args) {
        Object[] @Nullable [] err = new Object[10][10];
        Object [] [] e1 = NullnessUtils.castNonNull(err);
        e1[0][0].toString();
    }
}