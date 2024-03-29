<style>
.samples th, .samples td {
    border: 1px solid black;
    border-collapse: collapse;
    padding: 15px;
    width: 300px;
    /*max-width: 100%;*/
    /*text-align: center;*/
    /*alignment: center;*/
}

.sample th, .sample td {
    border: 1px solid black;
    padding: 15px;
    width: 300px;
    /*max-width: 100%;*/
    /*text-align: center;*/
    /*alignment: center;*/
}

.sample td {
    border-top: none;
    border-bottom: none;
}

.sample table {
    border-collapse: collapse;
    border: 1px solid black;
}

.logo {
    display: flex;
    justify-content: center;
}

.logo img {
    width: 200px;
    align: center;
}

.code span {
    line-height: 22px;
}
</style>

# Generate Binary Strings

<div class="logo">
    <img src="../../images/binary_strings_logo.png">
</div>

Given an integer $n$, generate all binary (consisting of `'0'` and `'1'`)
strings of length $n$.
The strings should be lexicographically ordered.

### Input

Given an `Int` $n$ — the length of strings ($0 \le n \le 20$).

### Output

Return a `List<String>` that contains the required binary strings.
The list should be lexicographically ordered.

### Example

<div class="samples">

| Input | Returns                    |
|-------|----------------------------|
| `2`   | `["00", "01", "10", "11"]` |

</div>

<div class="hint">
### Solution

Let's take a look at the list of all binary strings of length 3 sorted in the
lexicographic order:

* ${\tt 000}$
* ${\tt 001}$
* ${\tt 010}$
* ${\tt 011}$
* ${\tt 100}$
* ${\tt 101}$
* ${\tt 110}$
* ${\tt 111}$

Thus, we first need to generate four strings starting with 0 and
then generate four strings starting with 1. This can be done recursively:
start with an empty string $s$; within each recursive call, first append
${\tt 0}$ to $s$ and proceed recursively, then append ${\tt 1}$ to $s$
and proceed recursively. The call to $\operatorname{GenerateBinaryStrings}(s, n)$
for an empty string $s$ populates the list with all binary strings of length $n$.

<img src="../../images/binary_strings_1.png">

Another (though similar) way to generate all binary strings is based on the
following observation: by cutting the first symbol out of the first four strings
of length three, one gets all binary strings of length two, in the lexicographic
order (and the same holds for the last four strings). This leads to the
following recursive algorithm: generate all binary strings of length $n-1$;
then prepend ${\tt 0}$ to all of them, then prepend ${\tt 1}$ to all of them.

<img src="../../images/binary_strings_2.png">





</div>