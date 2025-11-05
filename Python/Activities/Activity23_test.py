# test_activity23.py
import pytest

# Fixture to initialize list 0-10
@pytest.fixture
def num_list():
    return list(range(11))  # [0, 1, 2, ..., 10]

# Test method to check sum
def test_sum_of_list(num_list):
    assert sum(num_list) == 55
