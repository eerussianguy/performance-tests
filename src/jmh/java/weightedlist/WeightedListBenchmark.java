package weightedlist;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;

public class WeightedListBenchmark
{
    public static final Random RANDOM = new Random();

    public static final IWeightedList<String> PARALLEL_LIST_1000 = new ParallelListWeightedList<>();
    public static final IWeightedList<String> BINARY_SEARCH_LIST_1000 = new ParallelListBinarySearchWeightedList<>();
    public static final IWeightedList<String> TREE_MAP_LIST_1000 = new TreeMapWeightedList<>();
    public static final AliasTableWeightedList<String> ALIAS_LIST_1000 = new AliasTableWeightedList<>();

    public static final IWeightedList<String> PARALLEL_LIST_100 = new ParallelListWeightedList<>();
    public static final IWeightedList<String> BINARY_SEARCH_LIST_100 = new ParallelListBinarySearchWeightedList<>();
    public static final IWeightedList<String> TREE_MAP_LIST_100 = new TreeMapWeightedList<>();
    public static final AliasTableWeightedList<String> ALIAS_LIST_100 = new AliasTableWeightedList<>();

    public static final IWeightedList<String> PARALLEL_LIST_10 = new ParallelListWeightedList<>();
    public static final IWeightedList<String> BINARY_SEARCH_LIST_10 = new ParallelListBinarySearchWeightedList<>();
    public static final IWeightedList<String> TREE_MAP_LIST_10 = new TreeMapWeightedList<>();
    public static final AliasTableWeightedList<String> ALIAS_LIST_10 = new AliasTableWeightedList<>();

    public static final IWeightedList<String> PARALLEL_LIST_1 = new ParallelListWeightedList<>();
    public static final IWeightedList<String> BINARY_SEARCH_LIST_1 = new ParallelListBinarySearchWeightedList<>();
    public static final IWeightedList<String> TREE_MAP_LIST_1 = new TreeMapWeightedList<>();
    public static final AliasTableWeightedList<String> ALIAS_LIST_1 = new AliasTableWeightedList<>();
    public static final IWeightedList<String> SINGLETON_LIST_1 = IWeightedList.singleton("test");

    static
    {
        // Initialize all lists to their required size
        for (int i = 0; i < 1000; i++)
        {
            String id = String.valueOf(RANDOM.nextInt());
            double weight = RANDOM.nextDouble();

            PARALLEL_LIST_1000.add(weight, id);
            BINARY_SEARCH_LIST_1000.add(weight, id);
            TREE_MAP_LIST_1000.add(weight, id);
            ALIAS_LIST_1000.add(weight, id);
        }

        for (int i = 0; i < 100; i++)
        {
            String id = String.valueOf(RANDOM.nextInt());
            double weight = RANDOM.nextDouble();

            PARALLEL_LIST_100.add(weight, id);
            BINARY_SEARCH_LIST_100.add(weight, id);
            TREE_MAP_LIST_100.add(weight, id);
            ALIAS_LIST_100.add(weight, id);
        }

        for (int i = 0; i < 10; i++)
        {
            String id = String.valueOf(RANDOM.nextInt());
            double weight = RANDOM.nextDouble();

            PARALLEL_LIST_10.add(weight, id);
            BINARY_SEARCH_LIST_10.add(weight, id);
            TREE_MAP_LIST_10.add(weight, id);
            ALIAS_LIST_10.add(weight, id);
        }

        PARALLEL_LIST_1.add(1.0, "test");
        BINARY_SEARCH_LIST_1.add(1.0, "test");
        TREE_MAP_LIST_1.add(1.0, "test");
        ALIAS_LIST_1.add(1.0, "test");

        // Alias lists need to be additionally initialized before used
        ALIAS_LIST_1000.init();
        ALIAS_LIST_100.init();
        ALIAS_LIST_10.init();
        ALIAS_LIST_1.init();
    }
/*
    @Benchmark
    public String benchmarkParallelListWeightedListGet1000()
    {
        return PARALLEL_LIST_1000.get(RANDOM);
    }
*/
    @Benchmark
    public String benchmarkParallelListBinarySearchWeightedListGet1000()
    {
        return BINARY_SEARCH_LIST_1000.get(RANDOM);
    }

    @Benchmark
    public String benchmarkTreeMapWeightedListGet1000()
    {
        return TREE_MAP_LIST_1000.get(RANDOM);
    }

    @Benchmark
    public String benchmarkAliasWeightedListGet1000()
    {
        return ALIAS_LIST_1000.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListWeightedListGet100()
    {
        return PARALLEL_LIST_100.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListBinarySearchWeightedListGet100()
    {
        return BINARY_SEARCH_LIST_100.get(RANDOM);
    }

    @Benchmark
    public String benchmarkTreeMapWeightedListGet100()
    {
        return TREE_MAP_LIST_100.get(RANDOM);
    }

    @Benchmark
    public String benchmarkAliasWeightedListGet100()
    {
        return ALIAS_LIST_100.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListWeightedListGet10()
    {
        return PARALLEL_LIST_10.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListBinarySearchWeightedListGet10()
    {
        return BINARY_SEARCH_LIST_10.get(RANDOM);
    }

    @Benchmark
    public String benchmarkTreeMapWeightedListGet10()
    {
        return TREE_MAP_LIST_10.get(RANDOM);
    }

    @Benchmark
    public String benchmarkAliasWeightedListGet10()
    {
        return ALIAS_LIST_10.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListWeightedListGet1()
    {
        return PARALLEL_LIST_1.get(RANDOM);
    }

    @Benchmark
    public String benchmarkParallelListBinarySearchWeightedListGet1()
    {
        return BINARY_SEARCH_LIST_1.get(RANDOM);
    }

    @Benchmark
    public String benchmarkTreeMapWeightedListGet1()
    {
        return TREE_MAP_LIST_1.get(RANDOM);
    }

    @Benchmark
    public String benchmarkAliasWeightedListGet1()
    {
        return ALIAS_LIST_1.get(RANDOM);
    }

    @Benchmark
    public String benchmarkSingletonListWeightedListGet1()
    {
        return SINGLETON_LIST_1.get(RANDOM);
    }
}
