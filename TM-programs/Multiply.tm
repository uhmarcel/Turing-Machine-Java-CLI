# Multiply TM program
# Outputs the multiplication of two inputs on alphabet {1}*

# For each multiplicand, copy input to end of tape
q0]r (#, q1)
q1]r (1/M, q2) (#, q8)    # Mark current multiplicand, and copy input
q2]l (#, q3)

# Copy first input at end of tape
q3]l (1/X, q4) (#, q0)    # Mark current char being copied
q4]r (#, q5)        
q5]r (#, q6)
q6]r (#/1, q7)
q7]l (X/1, q3)            # Remove mark and recover

# All multiplicands processed, finish 
q8]l (M/1, q8) (#, q9)
q9]r (#, q-1)

