import org.apache.spark.sql.functions._

// =====================================
// Task 2: Read dataset using Scala
// =====================================

val df = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("data/istanbul.csv")

println("Dataset loaded successfully!")

df.printSchema()


// =====================================
// Task 3: Print only DataFrame header
// =====================================

println("\nTask 3: DataFrame Header")

println(df.columns.mkString(" | "))
