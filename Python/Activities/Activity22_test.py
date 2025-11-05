# test_activity21.py

import pytest

# Test sum of two numbers
def test_sum():
    a = 10
    b = 5
    assert a + b == 15

# Test difference of two numbers
def test_difference():
    a = 10
    b = 5
    assert a - b == 5

# Test product of two numbers
@pytest.mark.activity  # Applying custom marker
def test_product():
    a = 10
    b = 5
    assert a * b == 50

# Test quotient of two numbers
@pytest.mark.activity  # Applying custom marker
def test_quotient():
    a = 10
    b = 5
    assert a / b == 2
