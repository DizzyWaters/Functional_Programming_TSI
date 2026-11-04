import org.apache.spark.sql.functions._

// =====================================
// Task 2: Read dataset using Scala
// =====================================

// Task 2: Read dataset

val df = spark.read
  .option("header", "true")
  .option("inferSchema", "true")
  .csv("data/istanbul.csv")
  .toDF("date", "ISE1", "ISE2", "SP", "DAX",
        "FTSE", "NIKKEI", "BOVESPA", "EU", "EM")


// =====================================
// Task 3: Print only DataFrame header
// =====================================


println("\nTask 3: DataFrame Header")
println(df.columns.mkString(" | "))


// =====================================
// Task 4: Print first 5 rows
// =====================================

println("\nTask 4: First 5 rows of DataFrame")

df.show(5, truncate = false)

// Task 5: Sort DataFrame by date descending

println("\nTask 5: Sort by date descending")

val sortedDF = df.orderBy(df("date").desc)

sortedDF.show(5)

// =====================================
// Task 6: Remove EM column
// =====================================

println("\nTask 6: Remove EM column")

val dfWithoutEM = df.drop("EM")

dfWithoutEM.show(5)

// =====================================
// Task 7: Sort by highest NIKKEI Index
// =====================================

println("\nTask 7: Sort by highest NIKKEI Index")

val sortedNikkeiDF = df.orderBy(df("NIKKEI").desc)

sortedNikkeiDF.show(5)

// Task 8: Create new column with mean of DAX and FTSE

println("\nTask 8: Mean of DAX and FTSE")

val dfWithMean = df.withColumn(
  "Mean_DAX_FTSE",
  (df("DAX") + df("FTSE")) / 2
)

dfWithMean.select("date", "DAX", "FTSE", "Mean_DAX_FTSE").show(5)


// Task 9: Find highest value by column number

println("\nTask 9: Highest value from selected column")

def highestValue(columnNumber: Int): Double = {
  val columnName = df.columns(columnNumber)
  df.agg(max(col(columnName))).first().getDouble(0)
}

println("Highest NIKKEI value: " + highestValue(6))


// =====================================
// Task 10: Save DataFrame to CSV
// =====================================

println("\nTask 10: Save DataFrame to CSV")

dfWithMean.write
  .mode("overwrite")
  .option("header", "true")
  .csv("output/result")

println("DataFrame saved successfully!")
