
# Task 1 : X is a normally distributed variable with a mean of 30 and a standard deviation of 4, find P(35 < X <42)

import scipy.stats

norm_dist = scipy.stats.norm(30, 4)
p1 = norm_dist.cdf(42)
p2 = norm_dist.cdf(35)

print(f'{p1-p2:.3f}')