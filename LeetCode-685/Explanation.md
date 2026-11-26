# Redundant Connection II

If a node has two incoming edges, skip the later one and check for a cycle using union-find. If a cycle remains, remove the earlier incoming edge. Otherwise remove the skipped edge. When every node has one incoming edge, return the edge that closes the cycle.
